package com.example.fdchallenge.exception;

public class ShortCustomerPasswordException extends RuntimeException {
    public ShortCustomerPasswordException(String message) {
        super(message);
    }
}
