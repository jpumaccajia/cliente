package com.nttdata.jpuma.cliente.infraestructure.rest.spring.mapper;

import com.nttdata.jpuma.cliente.domain.Cliente;
import com.nttdata.jpuma.cliente.infraestructure.rest.spring.dto.ClienteDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteDto toDto (Cliente cliente);

    Cliente toDomain(ClienteDto clienteDto);
}
