package com.ms.fair_service.mappers;

import com.ms.fair_service.dtos.response.ApiResponseDTO;

public class ApiResponseMapper {

    public static ApiResponseDTO<Void> error(int statusCode, String message) {
        return new ApiResponseDTO<>(false, statusCode, message, null);
    }

    public static <T> ApiResponseDTO<T> success(int statusCode, String message, T data) {
        return new ApiResponseDTO<>(true, statusCode, message, data);
    }
}
