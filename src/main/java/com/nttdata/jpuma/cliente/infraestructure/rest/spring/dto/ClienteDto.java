package com.nttdata.jpuma.cliente.infraestructure.rest.spring.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {

    private String id;
    private String tipoDocumento;
    private String nroDocumento;
    private String direccion;
    private String telefono;
    private String email;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
}
