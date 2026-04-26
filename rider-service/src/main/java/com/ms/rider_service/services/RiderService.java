package com.ms.rider_service.services;


import com.ms.rider_service.dtos.request.LocationUpdateRequestDTO;

public interface RiderService {
    void locationUpdate(LocationUpdateRequestDTO body,Long loggedInRiderId);
}
