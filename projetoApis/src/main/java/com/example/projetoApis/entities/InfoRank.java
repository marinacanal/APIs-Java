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

public class InfoRank {
    private String localidade;
    private String sexo;
    private List<Ranking> res;
}