package com.generic.uip.common.exception;

public class ZeroRecordException extends RuntimeException {

    public ZeroRecordException(String message) {
        super(message);
    }

    public ZeroRecordException(String message, Throwable cause) {
        super(message, cause);
    }
}
