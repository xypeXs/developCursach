package ru.rsatu.trade.exception;

public class SupplierOfferException extends BaseBusinessException {
    public SupplierOfferException() {
        super();
    }

    public SupplierOfferException(String message) {
        super(message);
    }

    public SupplierOfferException(String message, Throwable cause) {
        super(message, cause);
    }

    public SupplierOfferException(String formatMessage, Object... args) {
        super(formatMessage, args);
    }
}
