package com.ms.rider_service.mappers;

import com.ms.rider_service.dtos.request.SignupRequestDTO;
import com.ms.rider_service.dtos.response.RiderResponseDTO;
import com.ms.rider_service.entities.Rider;

public class RiderMapper {
   public static Rider toEntity(SignupRequestDTO body){
        Rider rider=new Rider();
        rider.setName(body.name());
        rider.setMobileNo(body.mobileNo());
        rider.setEmail(body.email());
        return rider;
    }

    public static RiderResponseDTO toDto(Rider rider){
       return RiderResponseDTO.builder()
               .id(rider.getId())
               .name(rider.getName())
               .mobileNo(rider.getMobileNo())
               .email(rider.getEmail())
               .build();
    }
}
