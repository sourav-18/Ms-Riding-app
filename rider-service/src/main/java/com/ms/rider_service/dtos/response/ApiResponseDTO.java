package com.ms.rider_service.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponseDTO<T> extends BaseApiResponseDTO {
    private final T data;

    public ApiResponseDTO(boolean success,int statusCode, String message, T data) {
        super(success, statusCode, message);
        this.data=data;
    }
}
