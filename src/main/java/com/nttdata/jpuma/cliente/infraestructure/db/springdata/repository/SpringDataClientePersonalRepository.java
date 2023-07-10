package com.nttdata.jpuma.cliente.infraestructure.db.springdata.repository;

import com.nttdata.jpuma.cliente.infraestructure.db.springdata.dbo.ClientePersonalEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SpringDataClientePersonalRepository extends ReactiveMongoRepository<ClientePersonalEntity, String> {
}
