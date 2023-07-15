package com.me.error;

import org.springframework.http.HttpStatus;


public abstract class AbstractApiBaseException extends RuntimeException{

    public AbstractApiBaseException(String message) {
        super(message);
    }

    public abstract HttpStatus getStatusCode();
}
