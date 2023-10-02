package com.example.projetoApis.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.projetoApis.entities.User;

@RestController
public class UserControllerRest {

    @GetMapping("/usuariosLista")
    public List<User> getUsersLista(Model model) {
        // URL da API JSONPlaceholder para obter a lista de usuários
        String apiUrl = "https://jsonplaceholder.typicode.com/users";

        // Inicializa o RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Faz uma solicitação GET para a API e obtém a resposta como uma lista de
        // objetos User
        ResponseEntity<User[]> response = restTemplate.getForEntity(apiUrl, User[].class);
        List<User> users = Arrays.asList(response.getBody());

        return users;
    }

}
