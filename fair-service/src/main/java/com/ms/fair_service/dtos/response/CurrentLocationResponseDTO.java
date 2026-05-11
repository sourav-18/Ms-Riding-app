package com.ms.fair_service.dtos.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrentLocationResponseDTO {
    private double latitude;
    private double longitude;
}
