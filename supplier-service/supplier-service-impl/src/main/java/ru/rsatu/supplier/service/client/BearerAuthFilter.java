package ru.rsatu.supplier.service.client;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;

import java.io.IOException;

public abstract class BearerAuthFilter implements ClientRequestFilter {


    public abstract void filter(ClientRequestContext clientRequestContext) throws IOException;

    protected abstract String issueToken();
}
