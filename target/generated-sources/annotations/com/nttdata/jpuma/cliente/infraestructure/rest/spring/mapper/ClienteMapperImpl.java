package com.nttdata.jpuma.cliente.infraestructure.rest.spring.mapper;

import com.nttdata.jpuma.cliente.domain.Cliente;
import com.nttdata.jpuma.cliente.infraestructure.rest.spring.dto.ClienteDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-10T13:39:19-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Microsoft)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteDto toDto(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteDto clienteDto = new ClienteDto();

        clienteDto.setId( cliente.getId() );
        clienteDto.setTipoDocumento( cliente.getTipoDocumento() );
        clienteDto.setNroDocumento( cliente.getNroDocumento() );
        clienteDto.setDireccion( cliente.getDireccion() );
        clienteDto.setTelefono( cliente.getTelefono() );
        clienteDto.setEmail( cliente.getEmail() );
        clienteDto.setFechaCreacion( cliente.getFechaCreacion() );
        clienteDto.setFechaModificacion( cliente.getFechaModificacion() );

        return clienteDto;
    }

    @Override
    public Cliente toDomain(ClienteDto clienteDto) {
        if ( clienteDto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setId( clienteDto.getId() );
        cliente.setTipoDocumento( clienteDto.getTipoDocumento() );
        cliente.setNroDocumento( clienteDto.getNroDocumento() );
        cliente.setDireccion( clienteDto.getDireccion() );
        cliente.setTelefono( clienteDto.getTelefono() );
        cliente.setEmail( clienteDto.getEmail() );
        cliente.setFechaCreacion( clienteDto.getFechaCreacion() );
        cliente.setFechaModificacion( clienteDto.getFechaModificacion() );

        return cliente;
    }
}
