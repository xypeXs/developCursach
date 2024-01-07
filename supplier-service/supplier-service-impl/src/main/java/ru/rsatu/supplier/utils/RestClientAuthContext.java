package ru.rsatu.supplier.utils;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class RestClientAuthContext {
    private static final Map<Pair<String, String>, String> TOKEN_MAP = new HashMap<>();

    public static String getToken(String clientId, String userName) {
        return TOKEN_MAP.get(new Pair<>(clientId, userName));
    }

    public static void setToken(String clientId, String userName, String token) {
        TOKEN_MAP.put(new Pair<>(clientId, userName), token);
    }

    public static void resetToken(String clientId, String userName) {
        TOKEN_MAP.remove(new Pair<>(clientId, userName));
    }
}
