package com.example.projetoApis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.projetoApis.validation.PaginaNaoEncontrada;

@Controller
public class SiteController {
    
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/websocket")
    public String websocket(){
        return "websocket";
    }

    @GetMapping("/websocket**")
    public void handleDefault() {
        throw new PaginaNaoEncontrada("Página não encontrada");
    }
}
