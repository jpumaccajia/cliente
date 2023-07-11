package com.nttdata.jpuma.cliente.infraestructure.rest.spring.resources;

import com.nttdata.jpuma.cliente.application.service.ClientService;
import com.nttdata.jpuma.cliente.infraestructure.rest.spring.dto.ClientDto;
import com.nttdata.jpuma.cliente.infraestructure.rest.spring.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class Resources {

    private final ClientService clienteService;

    private final ClientMapper clienteMapper;


    @GetMapping
    public Flux<ClientDto> getAllClientes() {
        return clienteService.getClientes()
                .map(clienteMapper::toDto);
    }

    @GetMapping("/{id}")
    public Mono<ClientDto> getClienteById(@PathVariable String id) {
        return clienteService.getCliente(id)
                .map(clienteMapper::toDto);
    }

    @PostMapping
    public Mono<ClientDto> createCliente(@RequestBody ClientDto clienteDto) {
        return clienteService.existsClienteByNroDocumento(clienteDto.getNroDocumento())
                .flatMap(existe -> {
                    if(existe) {
                        return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ya existe un cliente con el mismo número de documento"));
                    } else {
                        return clienteService.saveCliente(clienteMapper.toDomain(clienteDto))
                                .map(clienteMapper::toDto);
                    }
                });
    }

    @PutMapping
    public Mono<ClientDto> updateCliente(@RequestBody ClientDto clienteDto) {

        return clienteService.existsClienteById(clienteDto.getId())
                .flatMap(existe -> {
                    if(!existe) {
                        return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe un Cliente con el ID"));
                    } else {
                        return clienteService.saveCliente(clienteMapper.toDomain(clienteDto))
                                .map(clienteMapper::toDto);
                    }
                });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCliente(@PathVariable String id) {
        return clienteService.deleteCliente(id);
    }
}
