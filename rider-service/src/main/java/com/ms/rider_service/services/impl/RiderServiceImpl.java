package com.ms.rider_service.services.impl;

import com.ms.rider_service.dtos.request.LocationUpdateRequestDTO;
import com.ms.rider_service.exceptions.RiderNotFoundException;
import com.ms.rider_service.repositories.RiderRepository;
import com.ms.rider_service.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RiderServiceImpl implements RiderService {

    private final RiderRepository riderRepository;
    @Override
    @Transactional
    public void locationUpdate(LocationUpdateRequestDTO body,Long loggedInRiderId) {
       int updateCount= riderRepository.locationUpdateById(loggedInRiderId,body.latitude(),body.longitude());
       if(updateCount==0){
           throw new RiderNotFoundException(loggedInRiderId,"Rider not found");
       }
       return;
    }
}
