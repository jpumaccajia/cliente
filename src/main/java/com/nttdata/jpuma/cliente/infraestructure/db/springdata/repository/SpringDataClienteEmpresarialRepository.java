package com.nttdata.jpuma.cliente.infraestructure.db.springdata.repository;

import com.nttdata.jpuma.cliente.infraestructure.db.springdata.dbo.ClienteEmpresarialEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SpringDataClienteEmpresarialRepository extends ReactiveMongoRepository<ClienteEmpresarialEntity, String> {
}
