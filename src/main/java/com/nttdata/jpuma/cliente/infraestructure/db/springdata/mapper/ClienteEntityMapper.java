package com.nttdata.jpuma.cliente.infraestructure.db.springdata.mapper;

import com.nttdata.jpuma.cliente.domain.Cliente;
import com.nttdata.jpuma.cliente.infraestructure.db.springdata.dbo.ClienteEntity;
import org.mapstruct.Mapper;
import reactor.core.publisher.Mono;

@Mapper (componentModel = "spring")
public interface ClienteEntityMapper {

    Cliente toDomain(ClienteEntity clienteEntity);
    ClienteEntity toDbo(Cliente cliente);
}
