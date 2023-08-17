package com.nttdata.jpuma.cliente.adapters.api;

import com.nttdata.jpuma.cliente.adapters.api.dto.request.ClientRequestDto;
import com.nttdata.jpuma.cliente.adapters.api.dto.response.ClientResponseDto;
import com.nttdata.jpuma.cliente.application.service.ClientServiceImpl;
import com.nttdata.jpuma.cliente.adapters.api.mapper.ClientMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Log4j2
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientServiceImpl clienteService;

    private final ClientMapper clienteMapper;

    @Operation(summary = "Obtener todos los Clientes")
    @ApiResponse(responseCode = "200", description = "Se obtuvo respuesta correcta",
                content = { @Content(mediaType = MediaType.TEXT_EVENT_STREAM_VALUE,
                schema = @Schema(implementation = ClientResponseDto.class)) })
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ClientResponseDto> getClientes() {
        log.info(":::::::::::::: INICIO ::::::::::::::");
        log.info("1. Invocando servicio:  clienteService.getClientes()");
        return clienteService.getClientes()
                .map(clienteMapper::toDto);
    }

    @Operation(summary = "Obtener datos de un Cliente por Id")
    @GetMapping(value = "/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<ClientResponseDto> getClienteById(@PathVariable String id) {
        return clienteService.getCliente(id)
                .map(clienteMapper::toDto);
    }

    @Operation(summary = "Crear nuevo Cliente validando que el nro de documento no perteneza a otro cliente existente")
    @PostMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<ClientResponseDto> createCliente(@RequestBody ClientRequestDto clienteRequestDto) {
        return clienteService.saveCliente(clienteMapper.toDomain(clienteRequestDto))
                .map(clienteMapper::toDto);
    }

    @Operation(summary = "Actualiza los datos de un Cliente")
    @PutMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<ClientResponseDto> updateCliente(@RequestBody ClientRequestDto clienteRequestDto) {
        return clienteService.updateCliente(clienteMapper.toDomain(clienteRequestDto))
                .map(clienteMapper::toDto);
    }

    @Operation(summary = "Eliminar Cliente por Id")
    @DeleteMapping(value = "/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Void> deleteCliente(@PathVariable String id) {
        return clienteService.deleteCliente(id);
    }
}
