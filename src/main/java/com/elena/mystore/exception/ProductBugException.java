package com.elena.mystore.exception;

public class ProductBugException extends RuntimeException {

    public ProductBugException(String message, Throwable cause) {
        super(message, cause);
    }
}
