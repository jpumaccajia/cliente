package com.nttdata.jpuma.cliente.adapters.springboot;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@Log4j2
@SpringBootApplication(scanBasePackages = "com.nttdata.jpuma.cliente.adapters")
@EntityScan(basePackages = "com.nttdata.jpuma.cliente.domain")
public class SpringBootService {

	public static void main(String[] args) {
		log.info(":::::::::::::: START APLICCATION MSCLIENTE ::::::::::::::");
		SpringApplication.run(SpringBootService.class, args);
	}

}
