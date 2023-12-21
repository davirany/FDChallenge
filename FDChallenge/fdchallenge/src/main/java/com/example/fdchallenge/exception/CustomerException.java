package com.example.fdchallenge.exception;

import com.example.fdchallenge.ErrorMessage;

public class CustomerException {
    private final ErrorMessage errorMessage;

    public CustomerException(ErrorMessage errorMessage, Object... args) {
        super();
        this.errorMessage = errorMessage;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
