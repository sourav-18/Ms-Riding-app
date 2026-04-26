package com.ms.rider_service.controllers;

import com.ms.rider_service.dtos.request.LoginRequestDTO;
import com.ms.rider_service.dtos.request.SignupRequestDTO;
import com.ms.rider_service.dtos.response.RiderAuthResponseDTO;
import com.ms.rider_service.mappers.ApiResponseMapper;
import com.ms.rider_service.services.AuthService;
import com.ms.rider_service.utils.ApiUrlUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiUrlUtil.AUTH_URL)
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public Object signup(@Valid @RequestBody SignupRequestDTO body){
       RiderAuthResponseDTO response= authService.signup(body);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponseMapper.success(HttpStatus.CREATED.value(), "Rider signed up successfully",response));
    }

    @PostMapping("/login")
    public Object signup(@Valid @RequestBody LoginRequestDTO body){
        RiderAuthResponseDTO response= authService.login(body);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponseMapper.success(HttpStatus.OK.value(), "Rider login successfully",response));
    }


}
