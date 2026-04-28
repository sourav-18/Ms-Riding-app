package com.ms.fair_service.controllers;

import com.ms.fair_service.dtos.request.FairRequestDTO;
import com.ms.fair_service.dtos.response.ApiResponseDTO;
import com.ms.fair_service.dtos.response.FairResponseDTO;
import com.ms.fair_service.mappers.ApiResponseMapper;
import com.ms.fair_service.services.FairService;
import com.ms.fair_service.utils.ApiUrlUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiUrlUtil.FAIR_URL)
@RequiredArgsConstructor
public class FairController {

    private final FairService fairService;

    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<FairResponseDTO>>> getFair(@Valid @ModelAttribute FairRequestDTO body){
        List<FairResponseDTO> response=fairService.getFairList(body);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponseMapper.success(HttpStatus.OK.value(), "Fair list fetch successfully",response));

    }
}
