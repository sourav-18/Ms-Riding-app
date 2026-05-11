package com.ms.rider_service.feign;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FairResponseDTO {
    private VehicleEnum vehicleType;
    private Integer price;
    private Integer duration; // in minute
}
