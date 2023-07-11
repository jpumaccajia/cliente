package com.nttdata.jpuma.cliente.infraestructure.rest.spring.mapper;

import com.nttdata.jpuma.cliente.domain.Client;
import com.nttdata.jpuma.cliente.infraestructure.rest.spring.dto.ClientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDto toDto (Client cliente);

    Client toDomain(ClientDto clienteDto);
}
