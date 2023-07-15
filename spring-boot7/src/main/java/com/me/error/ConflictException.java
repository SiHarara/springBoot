package com.me.error;

import org.springframework.http.HttpStatus;

public class ConflictException extends AbstractApiBaseException{

    public ConflictException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
