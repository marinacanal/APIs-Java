package com.example.projetoApis.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.example.projetoApis.entities.Local;

@Controller
public class LocalController {

    @GetMapping("/locais")
    public String getLocaiss(Model model) {
        // URL da API JSONPlaceholder para obter a lista de usuários
        String apiUrl = "https://apps.tre-pe.jus.br/locaisVotacao/locais";

        // Inicializa o RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Faz uma solicitação GET para a API e obtém a resposta como uma lista de
        // objetos User
        ResponseEntity<Local[]> response = restTemplate.getForEntity(apiUrl, Local[].class);
        List<Local> locaiss = Arrays.asList(response.getBody());

        // Adicione a lista de usuários ao modelo para que possa ser usada na página HTML
        model.addAttribute("locaiss", locaiss);

        return "locais";
    }
}
