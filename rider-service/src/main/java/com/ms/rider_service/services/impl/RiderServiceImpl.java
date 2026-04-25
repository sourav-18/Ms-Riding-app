package com.ms.rider_service.services.impl;

import com.ms.rider_service.dtos.request.SignupRequestDTO;
import com.ms.rider_service.dtos.response.RiderResponseDTO;
import com.ms.rider_service.entities.Rider;
import com.ms.rider_service.mappers.RiderMapper;
import com.ms.rider_service.repositories.RiderRepository;
import com.ms.rider_service.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RiderServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final RiderRepository riderRepository;

    @Override
    public RiderResponseDTO signup(SignupRequestDTO body) {
        Rider rider= RiderMapper.toEntity(body);
        rider.setPassword(passwordEncoder.encode(body.password()));
        riderRepository.save(rider);
        return RiderMapper.toDto(rider);
    }
}
