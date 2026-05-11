package com.ms.fair_service.feign;
import com.ms.fair_service.dtos.response.ApiResponseDTO;
import com.ms.fair_service.dtos.response.CurrentLocationResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("RIDER-SERVICE")
public interface RiderFeign {
    @GetMapping("/api/v1/s2s/riders/{riderId}/current-location")
    ResponseEntity<ApiResponseDTO<CurrentLocationResponseDTO>> getCurrentLocation(@PathVariable Long riderId);
}
