package com.ms.fair_service.dtos.response;

import com.ms.fair_service.entities.enums.VehicleEnum;
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
