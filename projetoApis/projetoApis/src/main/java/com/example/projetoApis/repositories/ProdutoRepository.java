package com.example.projetoApis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetoApis.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
