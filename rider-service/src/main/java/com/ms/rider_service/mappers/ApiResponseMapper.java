package com.ms.rider_service.mappers;

import com.ms.rider_service.dtos.response.ApiResponseDTO;
import lombok.Getter;

public class ApiResponseMapper {

    public static ApiResponseDTO<Void> error(int statusCode, String message) {
        return new ApiResponseDTO<>(false, statusCode, message, null);
    }

    public static <T> ApiResponseDTO<T> success(int statusCode, String message, T data) {
        return new ApiResponseDTO<>(true, statusCode, message, data);
    }
}
