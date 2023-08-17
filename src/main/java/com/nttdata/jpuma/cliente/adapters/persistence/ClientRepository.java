package com.nttdata.jpuma.cliente.adapters.persistence;

import com.nttdata.jpuma.cliente.domain.model.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientRepository {

    Flux<Client> findAll();

    Mono<Client> findById(String id);

    Mono<Client> save(Client cliente);

    Mono<Void> deleteById(String id);

    Mono<Boolean> existsById(String id);

    Mono<Boolean> existsByNroDocumento(String nrodocumento);
}
