package com.ms.rider_service.exceptions;

import com.ms.rider_service.dtos.response.ApiResponseDTO;
import com.ms.rider_service.mappers.ApiResponseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptions {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponseDTO<Void>> handleValidationException(MethodArgumentNotValidException ex) {
        String errorsMessage = ex.getBindingResult().getFieldErrors().stream().findFirst()
                .map(FieldError::getDefaultMessage)
                .orElse("validation error");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponseMapper.error(
                        HttpStatus.BAD_REQUEST.value(),
                        errorsMessage));
    }

    @ExceptionHandler(MobileNoAlreadyExistException.class)
    public ResponseEntity<ApiResponseDTO<Void>> handleMobileNoAlreadyExistException(MobileNoAlreadyExistException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponseMapper.error(
                        HttpStatus.BAD_REQUEST.value(),
                        ex.getMessage()));
    }

    @ExceptionHandler(RiderNotFoundException.class)
    public ResponseEntity<ApiResponseDTO<Void>> handleRiderNotFoundExceptionException(RiderNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponseMapper.error(
                        HttpStatus.BAD_REQUEST.value(),
                        ex.getMessage()));
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<ApiResponseDTO<Void>> handleInvalidPasswordExceptionException(InvalidPasswordException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponseMapper.error(
                        HttpStatus.BAD_REQUEST.value(),
                        ex.getMessage()));
    }
}
