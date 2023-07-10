package com.nttdata.jpuma.cliente.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private String id;
    private String tipoDocumento;
    private String nroDocumento;
    private String direccion;
    private String telefono;
    private String email;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
}
