package com.nttdata.jpuma.cliente.adapters.springboot;

import com.nttdata.jpuma.cliente.adapters.persistence.ClientRepository;
import com.nttdata.jpuma.cliente.application.service.ClientServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.nttdata.jpuma.cliente.infraestructure.persistence")
public class SpringBootServiceConfig {
    @Bean
    public ClientServiceImpl clienteService(ClientRepository clienteRepository) {
        return new ClientServiceImpl(clienteRepository);
    }
}
