package com.ms.rider_service.dtos.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequestDTO(

        @NotBlank(message = "mobileNo can't be null")
        String mobileNo,

        @NotBlank(message = "password can't be null")
        @Size(min = 1, max = 20, message = "password must be between {min} to {max} character")
        String password
) {
}
