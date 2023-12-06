package com.generic.uip.common.exception;

public class CountMismatchException extends RuntimeException {

    public CountMismatchException(String message) {
        super(message);
    }

    public CountMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
