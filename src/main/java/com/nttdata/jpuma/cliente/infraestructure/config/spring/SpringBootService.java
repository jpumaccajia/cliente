package com.nttdata.jpuma.cliente.infraestructure.config.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = "com.nttdata.jpuma.cliente.infraestructure")
@EntityScan(basePackages = "com.nttdata.jpuma.cliente.domain")
public class SpringBootService {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootService.class, args);
	}

}
