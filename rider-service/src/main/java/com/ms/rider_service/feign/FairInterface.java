package com.ms.rider_service.feign;

import com.ms.rider_service.dtos.response.ApiResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("FAIR-SERVICE")
public interface FairInterface {
    @GetMapping("/api/v1/fairs")
    ResponseEntity<ApiResponseDTO<List<FairResponseDTO>>> getFair(@SpringQueryMap FairRequestDTO request);
}
