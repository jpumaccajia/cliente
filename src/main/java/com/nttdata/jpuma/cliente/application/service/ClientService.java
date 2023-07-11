package com.nttdata.jpuma.cliente.application.service;

import com.nttdata.jpuma.cliente.application.repository.ClientRepository;
import com.nttdata.jpuma.cliente.domain.Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
public class ClientService {
    private final ClientRepository clienteRepository;

    public Flux<Client> getClientes() {
        return clienteRepository.findAll();
    }
    public Mono<Client> getCliente(String id) {
        return clienteRepository.findById(id);
    }

    public Mono<Client> saveCliente(Client cliente) {
        return clienteRepository.save(cliente);
    }

    public Mono<Void> deleteCliente(String id) {
        return clienteRepository.deleteById(id);
    }

    public Mono<Boolean> existsClienteById(String id) {
        return clienteRepository.existsById(id);
    }

    public Mono<Boolean> existsClienteByNroDocumento(String nrodocumento) {
        return clienteRepository.existsByNroDocumento(nrodocumento);
    }
}
