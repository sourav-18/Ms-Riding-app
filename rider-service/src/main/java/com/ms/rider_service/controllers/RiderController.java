package com.ms.rider_service.controllers;

import com.ms.rider_service.dtos.request.LocationUpdateRequestDTO;
import com.ms.rider_service.mappers.ApiResponseMapper;
import com.ms.rider_service.services.RiderService;
import com.ms.rider_service.utils.ApiUrlUtil;
import com.ms.rider_service.utils.ConstantUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiUrlUtil.RIDER_URL)
public class RiderController {

    private final RiderService riderService;

    @PatchMapping("/locations")
    public Object locationUpdate(
            HttpServletRequest request,
            @Valid @RequestBody LocationUpdateRequestDTO body){
        Long loggedInRiderId= Long.valueOf((String) request.getAttribute(ConstantUtil.REQUEST_RIDER_ID_KEY));
        riderService.locationUpdate(body,loggedInRiderId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponseMapper.success(HttpStatus.OK.value(), "Location updated successfully",null));
    }
}
