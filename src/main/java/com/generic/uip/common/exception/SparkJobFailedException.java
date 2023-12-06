package com.generic.uip.common.exception;

public class SparkJobFailedException extends RuntimeException {

    public SparkJobFailedException(String message) {
        super(message);
    }

    public SparkJobFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
