package com.nttdata.jpuma.cliente.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClientePersonal extends Cliente{
    private String nombres;
    private String apPaterno;
    private String apMaterno;
}
