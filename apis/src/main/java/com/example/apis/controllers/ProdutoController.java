package com.example.apis.controllers;

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

import com.example.apis.entities.Produto;
import com.example.apis.repositories.ProdutoRepository;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/produto")

public class ProdutoController {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        var produtoOptional = produtoRepository.findById(id);
        if(produtoOptional.isEmpty()) {
            throw new EntityNotFoundException("Código não encotrado");
        }
        return produtoOptional.get();
    }
    
    @GetMapping
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Produto cadastrar (@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @PutMapping("/{id}")
    public Produto atualizarPorId(@PathVariable Long id, @RequestBody Produto produto) {
        var produtoOptional = produtoRepository.findById(id);
        if(produtoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        produto.setId(id);
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirPorId(@PathVariable Long id) {
        var produtoOptional = produtoRepository.findById(id);
        if(produtoOptional.isEmpty()) {
            throw new EntityNotFoundException("Código não encotrado");
        }
        produtoRepository.delete(produtoOptional.get());
    }
}
