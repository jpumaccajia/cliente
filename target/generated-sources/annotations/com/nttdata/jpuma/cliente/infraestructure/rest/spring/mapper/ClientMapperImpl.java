package com.nttdata.jpuma.cliente.infraestructure.rest.spring.mapper;

import com.nttdata.jpuma.cliente.domain.Client;
import com.nttdata.jpuma.cliente.infraestructure.rest.spring.dto.ClientDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-13T01:08:38-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Microsoft)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDto toDto(Client cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClientDto clientDto = new ClientDto();

        clientDto.setId( cliente.getId() );
        clientDto.setNombreCompleto( cliente.getNombreCompleto() );
        clientDto.setTipoDocumento( cliente.getTipoDocumento() );
        clientDto.setNroDocumento( cliente.getNroDocumento() );
        clientDto.setDireccion( cliente.getDireccion() );
        clientDto.setTelefono( cliente.getTelefono() );
        clientDto.setEmail( cliente.getEmail() );
        clientDto.setCategoria( cliente.getCategoria() );

        return clientDto;
    }

    @Override
    public Client toDomain(ClientDto clienteDto) {
        if ( clienteDto == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( clienteDto.getId() );
        client.setNombreCompleto( clienteDto.getNombreCompleto() );
        client.setTipoDocumento( clienteDto.getTipoDocumento() );
        client.setNroDocumento( clienteDto.getNroDocumento() );
        client.setDireccion( clienteDto.getDireccion() );
        client.setTelefono( clienteDto.getTelefono() );
        client.setEmail( clienteDto.getEmail() );
        client.setCategoria( clienteDto.getCategoria() );

        return client;
    }
}
