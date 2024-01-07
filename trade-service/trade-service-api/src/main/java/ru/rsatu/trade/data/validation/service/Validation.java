package ru.rsatu.trade.data.validation.service;

public class Validation {

    public static class Message {
        public static final String OFFER_EXISTS = "Запрещено создавать несколько предложений";
        public static final String DELIVERY_OFFER_PROHIBITED = "Запрещено создавать заказы по данному предложению";
    }
}
