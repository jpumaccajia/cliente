package com.nttdata.jpuma.cliente.infraestructure.db.springdata.repository;

import com.nttdata.jpuma.cliente.application.repository.ClienteRepository;
import com.nttdata.jpuma.cliente.domain.Cliente;
import com.nttdata.jpuma.cliente.infraestructure.db.springdata.dbo.ClienteEntity;
import com.nttdata.jpuma.cliente.infraestructure.db.springdata.mapper.ClienteEntityMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClienteDboRepository implements ClienteRepository {

    private final SpringDataClienteRepository clienteRepository;

    private final ClienteEntityMapper clienteMapper;

    @Override
    public Flux<Cliente> findAll(){
        return clienteRepository.findAll()
                .map(clienteMapper::toDomain);
    }
    @Override
    public Mono<Cliente> findById(String id) {
//        return clienteMapper.toDomain(clienteRepository.findById(id));
        return clienteRepository.findById(id)
                .map(clienteMapper::toDomain);
    }

    @Override
    public Mono<Cliente> save(Cliente cliente) {
        System.out.println("ClienteDboRepository :: save :: clienteMapper.toDbo(cliente) => " + clienteMapper.toDbo(cliente));
//        return clienteMapper.toDomain(clienteRepository.save(clienteMapper.toDbo(cliente)));
        return clienteRepository.save(clienteMapper.toDbo(cliente))
                .map(clienteMapper::toDomain);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return clienteRepository.deleteById(id);
    }

    @Override
    public Mono<Boolean> existsById(String id){
        return clienteRepository.existsById(id);
    }

    @Override
    public Mono<Boolean> existsByNroDocumento(String nrodocumento){
        return clienteRepository.existsByNroDocumento(nrodocumento);
    }

}

