package com.nttdata.jpuma.cliente.adapters.api.mapper;

import com.nttdata.jpuma.cliente.adapters.api.dto.request.ClientRequestDto;
import com.nttdata.jpuma.cliente.adapters.api.dto.response.ClientResponseDto;
import com.nttdata.jpuma.cliente.domain.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientResponseDto toDto (Client cliente);

    Client toDomain(ClientRequestDto clienteRequestDto);
}
