package com.nttdata.jpuma.cliente.infraestructure.db.springdata.dbo;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "cliente")
public class ClienteEntity {

    @Id
    private String id;
    private String tipoDocumento;
    private String nroDocumento;
    private String direccion;
    private String telefono;
    private String email;
    @CreatedDate
    private LocalDateTime fechaCreacion;
    @LastModifiedDate
    private LocalDateTime fechaModificacion;
}
