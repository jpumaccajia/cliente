package com.nttdata.jpuma.cliente.infraestructure.db.springdata.dbo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "cliente_empresarial")
public class ClienteEmpresarialEntity extends ClienteEntity {

    private String nombreEmpresa;
    private String contacto;
}
