package com.nttdata.jpuma.cliente.adapters.api.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(final String message) {
        super(message);
    }
}
