package com.nttdata.jpuma.cliente.infraestructure.db.springdata.repository;

import com.nttdata.jpuma.cliente.application.repository.ClientRepository;
import com.nttdata.jpuma.cliente.domain.Client;
import com.nttdata.jpuma.cliente.infraestructure.db.springdata.mapper.ClientEntityMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClientDboRepository implements ClientRepository {

    private final SpringDataClientRepository clienteRepository;

    private final ClientEntityMapper clienteMapper;

    @Override
    public Flux<Client> findAll(){
        return clienteRepository.findAll()
                .map(clienteMapper::toDomain);
    }
    @Override
    public Mono<Client> findById(String id) {
        return clienteRepository.findById(id)
                .map(clienteMapper::toDomain);
    }

    @Override
    public Mono<Client> save(Client cliente) {
        return clienteRepository.save(clienteMapper.toDbo(cliente))
                .map(clienteMapper::toDomain);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return clienteRepository.deleteById(id);
    }

    @Override
    public Mono<Boolean> existsById(String id){
        return clienteRepository.existsById(id);
    }

    @Override
    public Mono<Boolean> existsByNroDocumento(String nrodocumento){
        return clienteRepository.existsByNroDocumento(nrodocumento);
    }

}

