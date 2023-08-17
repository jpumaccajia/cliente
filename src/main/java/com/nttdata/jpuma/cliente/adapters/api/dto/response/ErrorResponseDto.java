package com.nttdata.jpuma.cliente.adapters.api.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ErrorResponseDto {
    private int statusCode;
    private String message;
    private List<String> errors;
}
