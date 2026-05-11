package com.ms.rider_service.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RiderNotFoundException extends RuntimeException {
    private final static String defaultMessage="Rider not found";

    public RiderNotFoundException(String mobileNo,String message){
        super(message);
        log.error("Rider not found in this mobile no {}",mobileNo);
    }

    public RiderNotFoundException(String mobileNo){
        this(mobileNo,"Rider not found");
    }

    public RiderNotFoundException(Long id){
        super(defaultMessage);
        log.error("Rider not found in this riderId:{}",id);
    }

}
