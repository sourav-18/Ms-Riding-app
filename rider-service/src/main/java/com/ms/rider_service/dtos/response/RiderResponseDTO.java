package com.ms.rider_service.dtos.response;

import lombok.Builder;

@Builder
public class RiderResponseDTO {
    private Long id;
    private String name;
    private String mobileNo;
    private String email;
}
