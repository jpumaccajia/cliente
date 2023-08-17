package com.nttdata.jpuma.cliente.adapters.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestDto {
    private String id;
    @NotBlank
    private String nombreCompleto;
    @NotBlank
    private String tipoDocumento;
    @NotBlank
    @Size(min = 8, max = 11)
    private String nroDocumento;
    private String direccion;
    private String telefono;
    private String email;
    @NotBlank
    private String categoria;
}
