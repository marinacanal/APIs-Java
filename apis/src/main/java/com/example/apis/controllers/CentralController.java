package com.example.apis.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.example.apis.entities.Central;

@Controller
public class CentralController {

    @GetMapping("/centrais")
    public String getCentraiss(Model model) {
        
        // URL da API JSONPlaceholder para obter a lista de usuários
        String apiUrl = "https://apps.tre-pe.jus.br/locaisAtendimento/centrais";

        // Inicializa o RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Faz uma solicitação GET para a API e obtém a resposta como uma lista de
        // objetos User
        ResponseEntity<Central[]> response = restTemplate.getForEntity(apiUrl, Central[].class);
        List<Central> centraiss = Arrays.asList(response.getBody());

        // Adicione a lista de usuários ao modelo para que possa ser usada na página HTML
        model.addAttribute("centraiss", centraiss);

        return "centrais";
    }
   
}
