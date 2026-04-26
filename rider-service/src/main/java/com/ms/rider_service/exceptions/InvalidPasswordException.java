package com.ms.rider_service.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(Long userId,String password,String message) {
        super(message);
        log.info("user id:{} with password:{} invalid try",userId,password);
    }

    public InvalidPasswordException(Long userId,String password){
        this(userId,password,"Rider not found");
    }
}
