package com.ms.rider_service.controllers;

import com.ms.rider_service.dtos.response.ApiResponseDTO;
import com.ms.rider_service.dtos.response.CurrentLocationResponseDTO;
import com.ms.rider_service.mappers.ApiResponseMapper;
import com.ms.rider_service.services.RiderService;
import com.ms.rider_service.utils.ApiUrlUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiUrlUtil.S2S_URL)
@RequiredArgsConstructor
public class S2SController {

    private final RiderService riderService;

    @GetMapping("/{riderId}/current-location")
   ResponseEntity<ApiResponseDTO<CurrentLocationResponseDTO>> getRiderCurrentLocation(@PathVariable Long riderId){
        CurrentLocationResponseDTO response=riderService.getCurrentLocation(riderId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponseMapper.success(HttpStatus.OK.value(), "Rider current location fetch successfully",response));
    }

}
