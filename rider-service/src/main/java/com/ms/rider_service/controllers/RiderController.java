package com.ms.rider_service.controllers;

import com.ms.rider_service.dtos.request.RiderCreateRequestDTO;
import com.ms.rider_service.services.RiderService;
import com.ms.rider_service.utils.ApiUrlUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(ApiUrlUtil.RIDER_URL)
public class RiderController {

    private final RiderService riderService;

    @PostMapping
    public Object create(@Valid @RequestBody RiderCreateRequestDTO body){
        return null;
    }


}
