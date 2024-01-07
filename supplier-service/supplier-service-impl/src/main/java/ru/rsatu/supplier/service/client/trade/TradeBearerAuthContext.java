package ru.rsatu.supplier.service.client.trade;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import ru.rsatu.supplier.utils.RestClientAuthContext;

import java.io.IOException;

@Provider
public class TradeBearerAuthFilter implements ClientRequestFilter {

    @ConfigProperty(name = "quarkus.oidc.client-id")
    String clientId;

    @ConfigProperty(name = "quarkus.oidc.client-id")
    String userName;

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

    private String issueToken() {
        
    }
}
