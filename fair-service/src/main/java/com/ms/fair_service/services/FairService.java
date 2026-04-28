package com.ms.fair_service.services;

import com.ms.fair_service.dtos.request.FairRequestDTO;
import com.ms.fair_service.dtos.response.FairResponseDTO;

import java.util.List;

public interface FairService {
     List<FairResponseDTO> getFairList(FairRequestDTO body);;
}
