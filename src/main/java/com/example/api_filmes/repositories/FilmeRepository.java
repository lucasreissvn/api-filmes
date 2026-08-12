package com.example.api_filmes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api_filmes.entities.Filme;

public interface FilmeRepository extends JpaRepository<Filme,Long>{

}
