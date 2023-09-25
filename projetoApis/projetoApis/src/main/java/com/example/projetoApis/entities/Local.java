package com.example.projetoApis.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Local {
    private Long id;
    private int numeroLocal;
    private String nome;
    private int numeroZona;
    private String endereco;
    private String bairro;
    private String cep;
    private String municipio;
}
