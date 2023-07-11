package com.nttdata.jpuma.cliente.infraestructure.config.spring;

import com.nttdata.jpuma.cliente.application.repository.ClientRepository;
import com.nttdata.jpuma.cliente.application.service.ClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootServiceConfig {
    @Bean
    public ClientService clienteService(ClientRepository clienteRepository) {
        return new ClientService(clienteRepository);
    }
}
