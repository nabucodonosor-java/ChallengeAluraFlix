package com.alura.flix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.flix.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
