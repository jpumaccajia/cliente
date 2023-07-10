package com.nttdata.jpuma.cliente.application.service;

import com.nttdata.jpuma.cliente.application.repository.ClienteRepository;
import com.nttdata.jpuma.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public Flux<Cliente> getClientes() {
        return clienteRepository.findAll();
    }
    public Mono<Cliente> getCliente(String id) {
        return clienteRepository.findById(id);
    }

    public Mono<Cliente> saveCliente(Cliente cliente) {
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
