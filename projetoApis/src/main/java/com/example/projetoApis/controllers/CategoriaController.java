package com.example.projetoApis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

import com.example.projetoApis.entities.Categoria;
import com.example.projetoApis.repositories.CategoriaRepository;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/categoria")

public class CategoriaController {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable Long id) {
        var categoriaOptional = categoriaRepository.findById(id);
        if(categoriaOptional.isEmpty()) {
            throw new EntityNotFoundException("Código não encotrado");
        }
        return categoriaOptional.get();
    }

    @GetMapping
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Categoria cadastrar (@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @PutMapping("/{id}")
    public Categoria atualizarPorId(@PathVariable Long id, @RequestBody Categoria categoria) {
        var categoriaOptional = categoriaRepository.findById(id);
        if(categoriaOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        categoria.setId(id);
        return categoriaRepository.save(categoria);
    }

    @DeleteMapping("/{id}")
    public void excluirPorId(@PathVariable Long id) {
        categoriaRepository.deleteById(id);
    }
    
}