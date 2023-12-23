package ru.rsatu.cursach.data.validation.controller;

public class Validation {

    public static class Pattern {
        public static final String GOOD_NAME = "[a-zA-Zа-яА-Я\\d\\-. ]+";
        public static final String STORAGE_ADDRESS = "[a-zA-Zа-яА-Я\\d\\-,.: ]+";
        public static final String SUPPLIER_LEGAL_ADDRESS = "[a-zA-Zа-яА-Я\\d\\-.,: ]+";
        public static final String SUPPLIER_NAME = "[a-zA-Zа-яА-Я\\d\\-\"'., ]+";
    }

    public static class Message {
        public static final String STORAGE_ID_NULL = "Не заполнен идентификатор склада";
        public static final String GOOD_ID_NULL = "Не заполнен идентификатор товара";
        public static final String SUPPLIER_ID_NULL = "Не заполнен идентификатор поставщика";
        public static final String DELIVERY_DATE_NULL = "Не заполнена дата поставки";
        public static final String DELIVERY_DATE_NOT_VALID = "Недопустимая дата поставки";
        public static final String GOOD_QUANTITY_NULL = "Не заполнено количество товара";
        public static final String GOOD_QUANTITY_NOT_VALID = "Недопустимое количество товара";
        public static final String GOOD_NAME_NULL = "Не заполнено наименование товара";
        public static final String GOOD_PRICE_NULL = "Не заполнена цена товара";
        public static final String GOOD_HEIGHT_NULL = "Не заполнена высота товара";
        public static final String GOOD_WIDTH_NULL = "Не заполнена ширина товара";
        public static final String GOOD_LENGTH_NULL = "Не заполнена длина товара";
        public static final String GOOD_WEIGHT_NULL = "Не заполнена масса товара";
        public static final String GOOD_NAME_NOT_VALID = "Недопустимое наименование товара";
        public static final String GOOD_PRICE_NOT_VALID = "Недопустимая цена товара";
        public static final String GOOD_HEIGHT_NOT_VALID = "Недопустимая высота товара";
        public static final String GOOD_WIDTH_NOT_VALID = "Недопустимая ширина товара";
        public static final String GOOD_LENGTH_NOT_VALID = "Недопустимая длина товара";
        public static final String GOOD_WEIGHT_NOT_VALID = "Недопустимый вес товара";
        public static final String STORAGE_ADDRESS_NULL = "Не заполнен адрес склада";
        public static final String STORAGE_ADDRESS_NOT_VALID = "Недопустимый адрес склада";
        public static final String STORAGE_VOLUME_CAPACITY_NULL = "Не заполнена вместимость склада по объёму";
        public static final String STORAGE_WEIGHT_CAPACITY_NULL = "Не заполнена вместимость склада по массе";
        public static final String STORAGE_VOLUME_CAPACITY_NOT_VALID = "Недопустимая вместимость склада по объёму";
        public static final String STORAGE_WEIGHT_CAPACITY_NOT_VALID = "Недопустимая вместимость склада по массе";
        public static final String SUPPLIER_LEGAL_ADDRESS_NULL = "Не заполнен юридический адрес поставщика";
        public static final String SUPPLIER_LEGAL_ADDRESS_NOT_VALID = "Недопустимый юридический адрес поставщика";
        public static final String SUPPLIER_NAME_NULL = "Не заполнено наименование поставщика";
        public static final String SUPPLIER_NAME_NOT_VALID = "Недопустимое наименование поставщика";
        public static final String SUPPLIER_REG_DATE_NULL = "Не заполнена дата регистрации поставщика";
        public static final String SUPPLIER_REG_DATE_NOT_VALID = "Недопустимая дата регистрации поставщика";
    }
}
