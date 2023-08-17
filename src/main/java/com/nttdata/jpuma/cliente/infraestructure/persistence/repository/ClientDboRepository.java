package com.nttdata.jpuma.cliente.infraestructure.persistence.repository;

import com.nttdata.jpuma.cliente.adapters.persistence.ClientRepository;
import com.nttdata.jpuma.cliente.domain.model.Client;
import com.nttdata.jpuma.cliente.infraestructure.persistence.mapper.ClientEntityMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Log4j2
@Repository
public class ClientDboRepository implements ClientRepository {
    private final SpringDataClientRepository clienteDataRepository;

    private final ClientEntityMapper clienteMapper;

    @Override
    public Flux<Client> findAll(){
        log.info("3. Invocando data repositorio: clienteDataRepository.findAll()");
        return clienteDataRepository.findAll()
                .map(clienteMapper::toDomain);
    }
    @Override
    public Mono<Client> findById(String id) {
        return clienteDataRepository.findById(id)
                .map(clienteMapper::toDomain);
    }

    @Override
    public Mono<Client> save(Client cliente) {
        return clienteDataRepository.save(clienteMapper.toDbo(cliente))
                .map(clienteMapper::toDomain);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return clienteDataRepository.deleteById(id);
    }

    @Override
    public Mono<Boolean> existsById(String id){
        return clienteDataRepository.existsById(id);
    }

    @Override
    public Mono<Boolean> existsByNroDocumento(String nrodocumento){
        return clienteDataRepository.existsByNroDocumento(nrodocumento);
    }

}

