package com.example.projetoApis.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Nome {
    private String nome;
    private String localidade;
    private String sexo;
    private List<FrequenciaNome> res;
}
