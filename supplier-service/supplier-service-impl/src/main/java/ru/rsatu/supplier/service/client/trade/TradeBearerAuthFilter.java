package ru.rsatu.supplier.service.client.trade;

import jakarta.inject.Inject;
import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.Provider;
import ru.rsatu.supplier.service.client.AuthService;

import java.io.IOException;

@Provider
public class TradeBearerAuthFilter implements ClientRequestFilter {

    @Inject
    AuthService authService;

    @Override
    public void filter(ClientRequestContext clientRequestContext) throws IOException {
        MultivaluedMap<String, Object> headerMap = clientRequestContext.getHeaders();
        headerMap.putSingle("Authorization", "Bearer " + authService.issueToken());
    }
}
