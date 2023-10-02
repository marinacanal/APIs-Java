package com.example.projetoApis.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Central {
    private Long id;
    private String siglaCentral;
    private String nomeCentral;
    private String logradouro;
    private String bairro;
    private String municipio;
    private int cep;
    private String telefone;
    private String email;
    private String horarioFuncionamento;
}