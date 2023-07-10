package com.nttdata.jpuma.cliente.application.repository;

import com.nttdata.jpuma.cliente.domain.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteRepository {

    Flux<Cliente> findAll();

    Mono<Cliente> findById(String id);

    Mono<Cliente> save(Cliente cliente);

    Mono<Void> deleteById(String id);

    Mono<Boolean> existsById(String id);

    Mono<Boolean> existsByNroDocumento(String nrodocumento);
}
