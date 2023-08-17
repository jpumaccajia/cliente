package com.nttdata.jpuma.cliente.infraestructure.persistence.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.nttdata.jpuma.cliente.infraestructure.persistence.repository")
@ConfigurationProperties("spring.data.mongodb.uri")
@Log4j2
@NoArgsConstructor
@Getter
@Setter
@EnableReactiveMongoAuditing
@EntityScan(basePackages = "com.nttdata.jpuma.cliente.infraestructure.persistence.dbo")
public class MongoConfig {
}
