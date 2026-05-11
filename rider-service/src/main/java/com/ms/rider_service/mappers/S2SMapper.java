package com.ms.rider_service.mappers;

import com.ms.rider_service.dtos.response.CurrentLocationResponseDTO;
import com.ms.rider_service.entities.Rider;

public class S2SMapper {
    public static CurrentLocationResponseDTO toCurrentLocationResponseDTO(Rider rider){
        return CurrentLocationResponseDTO.builder()
                .latitude(rider.getLatitude())
                .longitude(rider.getLongitude())
                .build();
    }
}
