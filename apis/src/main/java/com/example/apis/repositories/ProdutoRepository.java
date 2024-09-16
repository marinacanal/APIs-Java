package com.example.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apis.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
