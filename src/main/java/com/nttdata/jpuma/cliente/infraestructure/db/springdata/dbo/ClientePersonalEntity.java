package com.nttdata.jpuma.cliente.infraestructure.db.springdata.dbo;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "cliente_personal")
public class ClientePersonalEntity extends ClienteEntity {

    private String nombres;
    private String apPaterno;
    private String apMaterno;
}
