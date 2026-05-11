package com.ms.fair_service.services.impl;

import com.ms.fair_service.dtos.request.FairRequestDTO;
import com.ms.fair_service.dtos.response.ApiResponseDTO;
import com.ms.fair_service.dtos.response.CurrentLocationResponseDTO;
import com.ms.fair_service.dtos.response.FairResponseDTO;
import com.ms.fair_service.entities.enums.VehicleEnum;
import com.ms.fair_service.exceptions.CurrentLocationNotSetException;
import com.ms.fair_service.feign.RiderFeign;
import com.ms.fair_service.services.FairService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FairServiceImpl implements FairService {

    private final RiderFeign riderFeign;

    public List<FairResponseDTO> getFairList( Long riderId) {
        try{
            ApiResponseDTO<CurrentLocationResponseDTO> currentLocationApiResponse = riderFeign.getCurrentLocation(riderId).getBody();
        }catch (Exception e){
            throw new CurrentLocationNotSetException("your currentLocation not set yet.");
        }
        return List.of(FairResponseDTO.builder()
                .price(10)
                .duration(100)
                .vehicleType(VehicleEnum.BIKE)
                .build());
    }

}
