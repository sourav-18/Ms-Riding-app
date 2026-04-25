package com.ms.rider_service.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BaseApiResponseDTO {
    private final boolean success;
    private final int statusCode;
    private final String message;
    private final LocalDateTime timestamp=LocalDateTime.now();

    public BaseApiResponseDTO(boolean success, Integer statusCode, String message) {
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
    }
}
