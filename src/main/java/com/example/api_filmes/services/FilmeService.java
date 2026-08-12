package com.example.api_filmes.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.api_filmes.entities.Filme;
import com.example.api_filmes.repositories.FilmeRepository;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository){
        this.filmeRepository=filmeRepository;
    }

    public Optional<Filme> buscarPorId(Long id){
        return filmeRepository.findById(id);
    }

    public Filme salvarFilme(Filme filme){
        return filmeRepository.save(filme);
    }

    public void deletarFilme(Long id){
        filmeRepository.deleteById(id);
    }
}
