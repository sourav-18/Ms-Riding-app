package com.ms.rider_service.services;


import com.ms.rider_service.dtos.request.SignupRequestDTO;
import com.ms.rider_service.dtos.response.RiderResponseDTO;

public interface AuthService {
    public RiderResponseDTO signup(SignupRequestDTO body);
}
