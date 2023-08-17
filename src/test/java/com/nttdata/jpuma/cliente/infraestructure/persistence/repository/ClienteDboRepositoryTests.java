package com.nttdata.jpuma.cliente.infraestructure.persistence.repository;

import com.nttdata.jpuma.cliente.infraestructure.persistence.dbo.ClientEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Objects;

//@ExtendWith(MockitoExtension.class)
//@ExtendWith(SpringExtension.class)
//@DataJpaTest
class ClienteDboRepositoryTests {

    @Autowired
    private SpringDataClientRepository clienteDataRepository;

//    private ClientEntity clienteEntity;


//    @DisplayName("Test para guardar un cliente")
//    @Test
    void testGuardarCliente(){
        //given - dado o condición previa o configuración
        ClientEntity empleado1 = ClientEntity.builder()
                .nombreCompleto("Juan Diaz")
                .tipoDocumento("DNI")
                .nroDocumento("46598732")
                .direccion("Calle 198")
                .telefono("987654321")
                .categoria("EPA")
                .email("p12@gmail.com")
                .build();

        //when - acción o el comportamiento que vamos a probar
        Mono<ClientEntity> clienteGuardado = clienteDataRepository.save(empleado1);

        //then - verificar la salida
        StepVerifier.create(clienteGuardado)
                .expectNextMatches(Objects::nonNull)
                .verifyComplete();

//        StepVerifier.create(clienteGuardado)
//                .expectNextMatches(saved -> saved.getId() != null)
//                .expectComplete()
//                .verify();
    }
}
