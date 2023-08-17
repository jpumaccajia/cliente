package com.nttdata.jpuma.cliente.infraestructure.persistence.dbo;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Document(collection = "cliente")
public class ClientEntity {

    @Id
    private String id;
    @NotBlank
    private String nombreCompleto;
    @NotBlank
    private String tipoDocumento;
    @NotBlank
    private String nroDocumento;
    private String direccion;
    private String telefono;
    private String email;
    @NotBlank
    private String categoria;

    @CreatedDate
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    private LocalDateTime fechaModificacion;
}
