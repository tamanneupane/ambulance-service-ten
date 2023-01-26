package com.aggregrator.ambulanceservice.exception;

import lombok.Getter;

import java.io.IOException;

public class AmbulanceNotFoundException extends RuntimeException {
    private String message;
    @Getter
    private int code;

    public AmbulanceNotFoundException(String message, int code){
        super(message);
        this.message = message;
        this.code = code;
    }
}
