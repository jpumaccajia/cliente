package com.nttdata.jpuma.cliente.application.service;

import com.nttdata.jpuma.cliente.adapters.api.exception.NotFoundException;
import com.nttdata.jpuma.cliente.adapters.api.exception.CustomException;
import com.nttdata.jpuma.cliente.adapters.persistence.ClientRepository;
import com.nttdata.jpuma.cliente.domain.model.Client;
import com.nttdata.jpuma.cliente.domain.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Log4j2
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clienteRepository;

    public Flux<Client> getClientes() {

        log.info("2. Invocando repositorio: clienteRepository.findAll()");
        return clienteRepository.findAll();
    }
    public Mono<Client> getCliente(String id) {
        return clienteRepository.findById(id)
                .switchIfEmpty(Mono
                        .error(new NotFoundException("No se encontró al cliente")));
    }

    public Mono<Client> saveCliente(Client cliente) {
        return clienteRepository.existsByNroDocumento(cliente.getNroDocumento())
                .flatMap( existe -> existe
                    ? Mono.error(new CustomException(HttpStatus.BAD_REQUEST,
                            "Ya existe un cliente con el mismo número de documento"))
                    : clienteRepository.save(cliente));

//        return clienteRepository.save(cliente);
    }

    public Mono<Client> updateCliente(Client cliente) {
        return clienteRepository.findById(cliente.getId())
                .filter( client -> client.getTipoDocumento().equals(cliente.getTipoDocumento()))
                .filter( client -> client.getNroDocumento().equals(cliente.getNroDocumento()))
                .flatMap(client -> {
                    cliente.setFechaCreacion(client.getFechaCreacion());
                    return clienteRepository.save(cliente);
                })
                .switchIfEmpty(Mono.error(new NotFoundException("No se encontró al cliente")));
    }

    public Mono<Void> deleteCliente(String id) {
        return  clienteRepository.findById(id)
                .hasElement()
                .flatMap(exists -> exists ? clienteRepository.deleteById(id)
                        : Mono.error(new NotFoundException(
                        "No se encontró al cliente a eliminar")));
    }

    public Mono<Boolean> existsClienteById(String id) {
        return clienteRepository.existsById(id);
    }

    public Mono<Boolean> existsClienteByNroDocumento(String nrodocumento) {
        return clienteRepository.existsByNroDocumento(nrodocumento);
    }
}
