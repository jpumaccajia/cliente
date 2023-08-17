package com.nttdata.jpuma.cliente.infraestructure.persistence.repository;

import com.nttdata.jpuma.cliente.infraestructure.persistence.dbo.ClientEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface SpringDataClientRepository extends ReactiveMongoRepository<ClientEntity, String> {
    Mono<Boolean> existsById(String id);
    Mono<Boolean> existsByNroDocumento(String nrodocumento);
}
