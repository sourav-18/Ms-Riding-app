package com.ms.fair_service.dtos.request;


import jakarta.validation.constraints.NotNull;

public record FairRequestDTO(
        @NotNull(message = "fromLatitude can't be null" )
        Double fromLatitude,

        @NotNull(message = "fromLongitude can't be null" )
        Double fromLongitude,

        @NotNull(message = "toLatitude can't be null" )
        Double toLatitude,

        @NotNull(message = "toLongitude can't be null" )
        Double toLongitude) {

}

