package ru.rsatu.supplier.service.client;

import io.quarkus.oidc.client.OidcClient;
import io.quarkus.oidc.client.Tokens;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class AuthService {

    @Inject
    OidcClient oidcClient;

    private volatile Tokens token;

    public String issueToken() {
        if (token == null || token.isAccessTokenExpired())
            token = oidcClient.getTokens().await().indefinitely();
        return token.getAccessToken();
    }
}
