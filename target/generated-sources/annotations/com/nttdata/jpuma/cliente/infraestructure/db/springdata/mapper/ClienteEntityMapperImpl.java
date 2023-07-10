package com.nttdata.jpuma.cliente.infraestructure.db.springdata.mapper;

import com.nttdata.jpuma.cliente.domain.Cliente;
import com.nttdata.jpuma.cliente.infraestructure.db.springdata.dbo.ClienteEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-10T13:39:19-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Microsoft)"
)
@Component
public class ClienteEntityMapperImpl implements ClienteEntityMapper {

    @Override
    public Cliente toDomain(ClienteEntity clienteEntity) {
        if ( clienteEntity == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setId( clienteEntity.getId() );
        cliente.setTipoDocumento( clienteEntity.getTipoDocumento() );
        cliente.setNroDocumento( clienteEntity.getNroDocumento() );
        cliente.setDireccion( clienteEntity.getDireccion() );
        cliente.setTelefono( clienteEntity.getTelefono() );
        cliente.setEmail( clienteEntity.getEmail() );
        cliente.setFechaCreacion( clienteEntity.getFechaCreacion() );
        cliente.setFechaModificacion( clienteEntity.getFechaModificacion() );

        return cliente;
    }

    @Override
    public ClienteEntity toDbo(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteEntity clienteEntity = new ClienteEntity();

        clienteEntity.setId( cliente.getId() );
        clienteEntity.setTipoDocumento( cliente.getTipoDocumento() );
        clienteEntity.setNroDocumento( cliente.getNroDocumento() );
        clienteEntity.setDireccion( cliente.getDireccion() );
        clienteEntity.setTelefono( cliente.getTelefono() );
        clienteEntity.setEmail( cliente.getEmail() );
        clienteEntity.setFechaCreacion( cliente.getFechaCreacion() );
        clienteEntity.setFechaModificacion( cliente.getFechaModificacion() );

        return clienteEntity;
    }
}
