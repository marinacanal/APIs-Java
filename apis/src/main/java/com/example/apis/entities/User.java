package com.example.apis.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Não é criado no banco de dados
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private Long id;
    private String name;
    private String username;
    private String email;
}
