package com.ms.rider_service.services;


import com.ms.rider_service.dtos.request.LoginRequestDTO;
import com.ms.rider_service.dtos.request.SignupRequestDTO;
import com.ms.rider_service.dtos.response.RiderAuthResponseDTO;

public interface AuthService {
    RiderAuthResponseDTO signup(SignupRequestDTO body);
    RiderAuthResponseDTO login(LoginRequestDTO body);
}
