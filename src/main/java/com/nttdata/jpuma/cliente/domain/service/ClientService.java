package com.nttdata.jpuma.cliente.domain.service;

import com.nttdata.jpuma.cliente.domain.model.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {

    Flux<Client> getClientes();

    Mono<Client> getCliente(String id);

    Mono<Client> saveCliente(Client cliente);

    Mono<Client> updateCliente(Client cliente);

    Mono<Void> deleteCliente(String id);

    Mono<Boolean> existsClienteById(String id);

    Mono<Boolean> existsClienteByNroDocumento(String nrodocumento);

}
