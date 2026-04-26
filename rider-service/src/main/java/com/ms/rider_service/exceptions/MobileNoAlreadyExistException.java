package com.ms.rider_service.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MobileNoAlreadyExistException extends RuntimeException {

   public MobileNoAlreadyExistException(String mobileNo,String message){
        super(message);
        log.error("mobile number already exist {}",mobileNo);
    }

    public MobileNoAlreadyExistException(String mobileNo){
        this(mobileNo,"Mobile no already exist");
    }
}
