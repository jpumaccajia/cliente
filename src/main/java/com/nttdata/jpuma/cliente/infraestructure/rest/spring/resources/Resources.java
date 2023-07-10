package com.nttdata.jpuma.cliente.infraestructure.rest.spring.resources;

import com.nttdata.jpuma.cliente.application.service.ClienteService;
import com.nttdata.jpuma.cliente.infraestructure.rest.spring.dto.ClienteDto;
import com.nttdata.jpuma.cliente.infraestructure.rest.spring.mapper.ClienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class Resources {

    private final ClienteService clienteService;

    private final ClienteMapper clienteMapper;


    @GetMapping
    public Flux<ClienteDto> getAllClientes() {
        return clienteService.getClientes()
                .map(clienteMapper::toDto);
    }

    @GetMapping("/{id}")
    public Mono<ClienteDto> getClienteById(@PathVariable String id) {
        System.out.println("Resources :: getUserById :: id => " + id);
//        return new ResponseEntity<>(clienteMapper.toDto(clienteService.getCliente(id)), HttpStatus.OK);
        return clienteService.getCliente(id)
                .map(clienteMapper::toDto);
    }

    @PostMapping
    public Mono<ClienteDto> saveCliente(@RequestBody ClienteDto clienteDto) {

        System.out.println("Resources :: saveUser :: clienteDto => " + clienteDto);
        return clienteService.existsClienteByNroDocumento(clienteDto.getNroDocumento())
                .flatMap(existe -> {
                    if(existe) {
                        return Mono.error(new IllegalArgumentException("Ya existe un cliente con el mismo número de documento"));
                    } else {
                        return clienteService.saveCliente(clienteMapper.toDomain(clienteDto))
                                .map(clienteMapper::toDto);
                    }
                });
    }

    @PutMapping
    public Mono<ClienteDto> actualizarCliente(@RequestBody ClienteDto clienteDto) {

        System.out.println("Resources :: actualizarCliente :: clienteDto => " + clienteDto);
        return clienteService.existsClienteById(clienteDto.getId())
                .flatMap(existe -> {
                    if(!existe) {
                        return Mono.error(new IllegalArgumentException("No existe un Cliente con el ID"));
                    } else {
                        return clienteService.saveCliente(clienteMapper.toDomain(clienteDto))
                                .map(clienteMapper::toDto);
                    }
                });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminarCliente(@PathVariable String id) {
        return clienteService.deleteCliente(id);
    }
}
