package ru.rsatu.model.keycloak;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TokenResponse {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("expires_in")
    private String expireTime;
    @JsonProperty("refresh_expires_in")
    private String refreshExpireTime;
    @JsonProperty("token_type")
    private String tokenType;
}
