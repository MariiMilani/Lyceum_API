package com.dev.Lyceum.API.infra.exception;

public class NotNullFieldException extends RuntimeException {
    public NotNullFieldException(String message) {
        super(message);
    }
}
