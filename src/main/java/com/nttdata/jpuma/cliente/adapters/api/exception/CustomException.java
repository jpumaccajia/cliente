package com.nttdata.jpuma.cliente.adapters.api.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    private final HttpStatus status;
    public CustomException(final HttpStatus httpStatus, final String message) {
        super(message);
        this.status = httpStatus;
    }
    public HttpStatus getStatus() {
        return status;
    }
}
