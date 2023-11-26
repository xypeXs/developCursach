package ru.rsatu.cursach.utils;

public class EncryptionUtils {

    public static String encryptFromLong(Long id) {
        return id.toString();
    }

    public static String encryptFromStr(String id) {
        return id;
    }

    public static Long decryptToLong(String encryptedId) {
        return Long.parseLong(encryptedId);
    }

    public static String decryptToStr(String encryptedId) {
        return encryptedId;
    }
}
