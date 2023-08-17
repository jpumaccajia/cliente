package com.nttdata.jpuma.cliente.adapters.api;

import com.nttdata.jpuma.cliente.adapters.api.exception.NotFoundException;
import com.nttdata.jpuma.cliente.adapters.api.exception.CustomException;
import com.nttdata.jpuma.cliente.adapters.api.dto.response.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(
            final Exception ex) {
        ErrorResponseDto response = ErrorResponseDto
                .builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Error inesperado")
                .errors(Collections.singletonList(ex.getMessage()))
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorResponseDto> runtimeExceptionHandler(
            final RuntimeException ex) {
        ErrorResponseDto error = ErrorResponseDto
                .builder()
                .statusCode(HttpStatus.BAD_GATEWAY.value())
                .message(ex.getMessage())
                .errors(Collections.singletonList(ex.getMessage()))
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleClientNotFoundException(
            final NotFoundException ex) {
        ErrorResponseDto response = ErrorResponseDto
                .builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .errors(Collections.singletonList(ex.getMessage()))
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<ErrorResponseDto> customExceptionHandler(
            final CustomException ex) {
        ErrorResponseDto error = ErrorResponseDto
                .builder()
                .statusCode(ex.getStatus().value())
                .message(ex.getMessage())
                .errors(Collections.singletonList(ex.getMessage()))
                .build();
        return new ResponseEntity<>(error, ex.getStatus());
    }

}
