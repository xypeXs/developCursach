package ru.rsatu.supplier.service.client.trade;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import ru.rsatu.model.keycloak.TokenResponse;
import ru.rsatu.supplier.service.client.BearerAuthFilter;
import ru.rsatu.supplier.service.client.keycloak.KeycloakRestClient;
import ru.rsatu.supplier.utils.RestClientAuthContext;

import java.io.IOException;
import java.util.Map;

@Provider
public class TradeBearerAuthFilter extends BearerAuthFilter {

    @ConfigProperty(name = "quarkus.oidc.client-id")
    String clientId;

    @ConfigProperty(name = "quarkus.oidc.client_secret")
    String clientSecret;

    @ConfigProperty(name = "rest-client.keycloak.username")
    String userName;

    @ConfigProperty(name = "rest-client.keycloak.password")
    String password;

    @RestClient
    KeycloakRestClient keycloakRestClient;

    @Override
    public void filter(ClientRequestContext clientRequestContext) throws IOException {
        MultivaluedMap<String, Object> headerMap = clientRequestContext.getHeaders();
        headerMap.putSingle("Authorization ", getToken());
    }

    private String getToken() {
        String token = RestClientAuthContext.getToken(clientId, userName);
        if (token == null) {
            token = issueToken();
            RestClientAuthContext.setToken(clientId, userName, token);
        }
        return token;
    }

    @Override
    protected String issueToken() {
        Map<String, String> requestMap = getTokenRequestMap();
        TokenResponse tokenResponse = keycloakRestClient.issueToken(requestMap);
        return tokenResponse.getAccessToken();
    }

    private Map<String, String> getTokenRequestMap() {
        return Map.of(
                "grant_type", "password",
                "client_id", clientId,
                "client_secret", clientSecret,
                "username", userName,
                "password", password
        );
    }
}
