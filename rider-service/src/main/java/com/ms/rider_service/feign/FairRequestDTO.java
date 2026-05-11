package com.ms.rider_service.feign;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FairRequestDTO{
        @NotNull(message = "fromLatitude can't be null" )
        Double fromLatitude;

        @NotNull(message = "fromLongitude can't be null" )
        Double fromLongitude;

        @NotNull(message = "toLatitude can't be null" )
        Double toLatitude;

        @NotNull(message = "toLongitude can't be null" )
        Double toLongitude;

}

