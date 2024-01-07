package ru.rsatu.supplier.service.client.keycloak;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestForm;
import ru.rsatu.model.keycloak.TokenResponse;
import ru.rsatu.supplier.data.client.RestClientConfig;

import java.util.Map;

@RegisterRestClient(configKey = RestClientConfig.Key.KEYCLOAK_API_KEY)
public interface KeycloakRestClient {
    @POST
    @Path("/realms/TRADE/protocol/openid-connect/token")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    TokenResponse issueToken(@RestForm Map<String, String> filters);
}
