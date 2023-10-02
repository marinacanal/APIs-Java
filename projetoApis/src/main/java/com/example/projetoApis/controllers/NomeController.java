package com.example.projetoApis.controllers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.projetoApis.entities.Nome;

@RestController
public class NomeController {
    
    private String apiUrl = "https://servicodados.ibge.gov.br/api/v2/censos/nomes/";

    @GetMapping("/nomes/{nome}")
    public List<Nome> getNome(@PathVariable String nome) {
        String url = apiUrl + "/" + nome;

        RestTemplate restTemplate = new RestTemplate();
        
        Nome[] nomeArray = restTemplate.getForObject(url, Nome[].class);

        if (nomeArray != null) {
            return Arrays.asList(nomeArray);
        } else {
            return Collections.emptyList();
        }

    }
}
