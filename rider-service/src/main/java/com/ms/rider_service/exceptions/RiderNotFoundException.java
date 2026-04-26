package com.ms.rider_service.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RiderNotFoundException extends RuntimeException {

    public RiderNotFoundException(String mobileNo,String message){
        super(message);
        log.error("Rider not found in this mobile no {}",mobileNo);
    }

    public RiderNotFoundException(String mobileNo){
        this(mobileNo,"Rider not found");
    }

    public RiderNotFoundException(Long id,String message){
        super(message);
        log.error("Rider not found in this riderId:{}",id);
    }

}
