package com.nttdata.jpuma.cliente.infraestructure.db.springdata.repository;

import com.nttdata.jpuma.cliente.infraestructure.db.springdata.dbo.ClienteEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface SpringDataClienteRepository extends ReactiveMongoRepository<ClienteEntity, String> {
    Mono<Boolean> existsById(String id);
    Mono<Boolean> existsByNroDocumento(String nrodocumento);
}
