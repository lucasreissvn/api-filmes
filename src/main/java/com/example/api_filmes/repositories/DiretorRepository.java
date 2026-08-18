package com.example.api_filmes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api_filmes.entities.Diretor;

public interface DiretorRepository extends JpaRepository<Diretor,Long>{

}