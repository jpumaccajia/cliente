package com.nttdata.jpuma.cliente.infraestructure.db.springdata.mapper;

import com.nttdata.jpuma.cliente.domain.Client;
import com.nttdata.jpuma.cliente.infraestructure.db.springdata.dbo.ClientEntity;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface ClientEntityMapper {

    Client toDomain(ClientEntity clienteEntity);
    ClientEntity toDbo(Client cliente);
}
