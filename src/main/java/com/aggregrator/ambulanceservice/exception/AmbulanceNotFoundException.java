package com.aggregrator.ambulanceservice.exception;

import java.io.IOException;

public class AmbulanceNotFoundException extends RuntimeException {

    private String message;
    private int code;

    public AmbulanceNotFoundException(String message, int code){
        super(message);
        this.message = message;
        this.code = code;
    }
}
