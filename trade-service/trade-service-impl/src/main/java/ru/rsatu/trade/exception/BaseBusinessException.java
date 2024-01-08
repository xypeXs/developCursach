package ru.rsatu.trade.exception;

public class BaseBusinessException extends RuntimeException {
    public BaseBusinessException() {
        super();
    }

    public BaseBusinessException(String message) {
        super(message);
    }

    public BaseBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseBusinessException(String formatMessage, Object... args) {
        super(String.format(formatMessage, args));
    }
}
