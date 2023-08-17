package com.nttdata.jpuma.cliente.adapters.api.dto.response;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponseDto {
    private String id;
    private String nombreCompleto;
    private String tipoDocumento;
    private String nroDocumento;
    private String direccion;
    private String telefono;
    private String email;
    private String categoria;
}
