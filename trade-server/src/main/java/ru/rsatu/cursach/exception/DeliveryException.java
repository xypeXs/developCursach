package ru.rsatu.cursach.exception;

public class DeliveryException extends BaseBusinessException {
    public DeliveryException() {
        super();
    }

    public DeliveryException(String message) {
        super(message);
    }

    public DeliveryException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeliveryException(String formatMessage, Object... args) {
        super(formatMessage, args);
    }
}
