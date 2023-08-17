package com.nttdata.jpuma.cliente.infraestructure.persistence.mapper;

import com.nttdata.jpuma.cliente.domain.model.Client;
import com.nttdata.jpuma.cliente.infraestructure.persistence.dbo.ClientEntity;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface ClientEntityMapper {

    Client toDomain(ClientEntity clienteEntity);
    ClientEntity toDbo(Client cliente);
}
