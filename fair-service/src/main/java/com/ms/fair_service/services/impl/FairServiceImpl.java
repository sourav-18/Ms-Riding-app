package com.ms.fair_service.services.impl;

import com.ms.fair_service.dtos.request.FairRequestDTO;
import com.ms.fair_service.dtos.response.FairResponseDTO;
import com.ms.fair_service.entities.enums.VehicleEnum;
import com.ms.fair_service.services.FairService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FairServiceImpl implements FairService {

    public List<FairResponseDTO> getFairList(FairRequestDTO body) {
        return List.of(FairResponseDTO.builder()
                .price(10)
                .duration(100)
                .vehicleType(VehicleEnum.BIKE)
                .build());
    }

}
