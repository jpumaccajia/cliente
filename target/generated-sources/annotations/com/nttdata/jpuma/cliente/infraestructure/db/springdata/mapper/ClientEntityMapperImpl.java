package com.nttdata.jpuma.cliente.infraestructure.db.springdata.mapper;

import com.nttdata.jpuma.cliente.domain.Client;
import com.nttdata.jpuma.cliente.infraestructure.db.springdata.dbo.ClientEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-11T16:25:36-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Microsoft)"
)
@Component
public class ClientEntityMapperImpl implements ClientEntityMapper {

    @Override
    public Client toDomain(ClientEntity clienteEntity) {
        if ( clienteEntity == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( clienteEntity.getId() );
        client.setNombreCompleto( clienteEntity.getNombreCompleto() );
        client.setTipoDocumento( clienteEntity.getTipoDocumento() );
        client.setNroDocumento( clienteEntity.getNroDocumento() );
        client.setDireccion( clienteEntity.getDireccion() );
        client.setTelefono( clienteEntity.getTelefono() );
        client.setEmail( clienteEntity.getEmail() );
        client.setCategoria( clienteEntity.getCategoria() );

        return client;
    }

    @Override
    public ClientEntity toDbo(Client cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setId( cliente.getId() );
        clientEntity.setNombreCompleto( cliente.getNombreCompleto() );
        clientEntity.setTipoDocumento( cliente.getTipoDocumento() );
        clientEntity.setNroDocumento( cliente.getNroDocumento() );
        clientEntity.setDireccion( cliente.getDireccion() );
        clientEntity.setTelefono( cliente.getTelefono() );
        clientEntity.setEmail( cliente.getEmail() );
        clientEntity.setCategoria( cliente.getCategoria() );

        return clientEntity;
    }
}
