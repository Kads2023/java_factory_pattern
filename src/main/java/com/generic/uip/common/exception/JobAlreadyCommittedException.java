package com.generic.uip.common.exception;

public class JobAlreadyCommittedException extends RuntimeException {

    public JobAlreadyCommittedException(String message) {
        super(message);
    }

    public JobAlreadyCommittedException(String message, Throwable cause) {
        super(message, cause);
    }
}
