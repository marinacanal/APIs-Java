package com.example.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apis.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
