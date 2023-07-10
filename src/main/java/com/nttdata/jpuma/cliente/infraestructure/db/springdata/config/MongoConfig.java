package com.nttdata.jpuma.cliente.infraestructure.db.springdata.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.nttdata.jpuma.cliente.infraestructure.db.springdata.repository")
@ConfigurationProperties("spring.data.mongodb.uri")
@Slf4j
@NoArgsConstructor
@Getter
@Setter
@EnableReactiveMongoAuditing
@EntityScan(basePackages = "com.nttdata.jpuma.cliente.infraestructure.db.springdata.dbo")
public class MongoConfig {
}
