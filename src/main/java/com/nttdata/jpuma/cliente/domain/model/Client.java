package com.nttdata.jpuma.cliente.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private String id;
    private String nombreCompleto;
    private String tipoDocumento;
    private String nroDocumento;
    private String direccion;
    private String telefono;
    private String email;
    private String categoria;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
}
