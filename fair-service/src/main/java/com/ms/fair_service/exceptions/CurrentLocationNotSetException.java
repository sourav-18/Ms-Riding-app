package com.ms.fair_service.exceptions;

public class CurrentLocationNotSetException extends RuntimeException {
    public CurrentLocationNotSetException(String message) {
        super(message);
    }
}
