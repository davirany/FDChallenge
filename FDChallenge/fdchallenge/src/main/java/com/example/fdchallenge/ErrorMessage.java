package com.example.fdchallenge;

public enum ErrorMessage {
    SHORT_CUSTOMER_NAME("Customer name must have at least 3 characters."),
    LONG_CUSTOMER_NAME("Customer name must have a 50 characters max."),
    INVALID_CUSTOMER_EMAIL("Invalid email format."),
    SHORT_CUSTOMER_PASSWORD("Customer password must have at least 6 characters."),
    LONG_CUSTOMER_PASSWORD("Customer password must have a 20 characters max.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String formatMessage(Object... args) {
        return String.format(message, args);
    }
}
