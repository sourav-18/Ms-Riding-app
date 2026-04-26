package com.ms.rider_service.services.impl;

import com.ms.rider_service.dtos.request.LoginRequestDTO;
import com.ms.rider_service.dtos.request.SignupRequestDTO;
import com.ms.rider_service.dtos.response.RiderAuthResponseDTO;
import com.ms.rider_service.entities.Rider;
import com.ms.rider_service.exceptions.InvalidPasswordException;
import com.ms.rider_service.exceptions.MobileNoAlreadyExistException;
import com.ms.rider_service.exceptions.RiderNotFoundException;
import com.ms.rider_service.mappers.RiderMapper;
import com.ms.rider_service.repositories.RiderRepository;
import com.ms.rider_service.services.AuthService;
import com.ms.rider_service.services.JwtService;
import com.ms.rider_service.utils.ConstantUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final RiderRepository riderRepository;
    private final JwtService jwtService;

    @Override
    public RiderAuthResponseDTO signup(SignupRequestDTO body) {
        boolean isRiderExist = riderRepository.existsByMobileNo(body.mobileNo());
        if (isRiderExist) {
            throw new MobileNoAlreadyExistException(body.mobileNo());
        }
        Rider rider = RiderMapper.toEntity(body);
        rider.setPassword(passwordEncoder.encode(body.password()));
        riderRepository.save(rider);
        String token = jwtService.generateToken(rider.getId().toString(), ConstantUtil.role);
        return RiderMapper.toAuthDto(rider, token);
    }

    @Override
    public RiderAuthResponseDTO login(LoginRequestDTO body) {
        Rider rider = riderRepository.findByMobileNo(body.mobileNo())
                .orElseThrow(() -> new RiderNotFoundException(body.mobileNo()));
        boolean matches = passwordEncoder.matches(body.password(), rider.getPassword());

        if (!matches) {
            throw new InvalidPasswordException(rider.getId(), body.password());
        }
        rider.setPassword(passwordEncoder.encode(body.password()));
        riderRepository.save(rider);
        String token = jwtService.generateToken(rider.getId().toString(), ConstantUtil.role);
        return RiderMapper.toAuthDto(rider, token);
    }


}
