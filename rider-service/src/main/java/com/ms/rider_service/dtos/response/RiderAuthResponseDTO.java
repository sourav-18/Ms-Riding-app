package com.ms.rider_service.dtos.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RiderAuthResponseDTO {
    private Long id;
    private String name;
    private String mobileNo;
    private String email;
    private String token;
}
