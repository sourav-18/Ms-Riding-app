package com.ms.rider_service.exceptions;

public class CurrentLocationNotSetException extends RuntimeException {
    public CurrentLocationNotSetException(String message) {
        super(message);
    }
}
