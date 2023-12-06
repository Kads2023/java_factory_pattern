package com.generic.uip.common.exception;


public class IncorrectArgumentsException extends Exception {

    public IncorrectArgumentsException(String message) {
        super(message);
    }

    public IncorrectArgumentsException(String message, Throwable cause) {
        super(message, cause);
    }

}
