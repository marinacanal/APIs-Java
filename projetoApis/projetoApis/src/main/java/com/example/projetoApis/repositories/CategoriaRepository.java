package com.example.projetoApis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetoApis.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
