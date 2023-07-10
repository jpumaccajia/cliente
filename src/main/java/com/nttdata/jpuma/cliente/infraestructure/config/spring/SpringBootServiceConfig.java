package com.nttdata.jpuma.cliente.infraestructure.config.spring;

import com.nttdata.jpuma.cliente.application.repository.ClienteRepository;
import com.nttdata.jpuma.cliente.application.service.ClienteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootServiceConfig {
    @Bean
    public ClienteService clienteService(ClienteRepository clienteRepository) {
        return new ClienteService(clienteRepository);
    }
}
