package com.nttdata.jpuma.cliente.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEmpresarial extends Cliente {
    private String nombreEmpresa;
    private String contacto;
}
