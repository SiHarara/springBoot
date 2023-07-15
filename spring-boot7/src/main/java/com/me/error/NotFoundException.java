package com.me.error;

import org.springframework.http.HttpStatus;

public class NotFoundException extends AbstractApiBaseException{

    public NotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
