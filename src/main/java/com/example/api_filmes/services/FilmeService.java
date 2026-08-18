package com.example.api_filmes.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.api_filmes.dto.FilmeDTO;
import com.example.api_filmes.entities.Filme;
import com.example.api_filmes.exceptions.FilmeNaoEncontradoException;
import com.example.api_filmes.repositories.FilmeRepository;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository){
        this.filmeRepository=filmeRepository;
    }

    public Filme buscarPorId(Long id){
        return filmeRepository.findById(id)
        .orElseThrow(() -> new FilmeNaoEncontradoException(id));
    }

    public Filme salvarFilme(FilmeDTO filmeDTO){
        Filme filme = new Filme();

        filme.setNome(filmeDTO.nome());
        filme.setDuracao(filmeDTO.duracao());
        filme.setGenero(filmeDTO.genero());
        filme.setDataLancamento(filmeDTO.dataLancamento());
        filme.setNota(filmeDTO.nota());

        return filmeRepository.save(filme);
    }

    public void deletarFilme(Long id) {
        if (!filmeRepository.existsById(id)) {
            throw new FilmeNaoEncontradoException(id);
        }

        filmeRepository.deleteById(id);
    }

    public Filme atualizarFilme(Long id, FilmeDTO filmeDTO){
        Filme filmeExistente = filmeRepository.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado"));

        filmeExistente.setNome(filmeDTO.nome());
        filmeExistente.setDuracao(filmeDTO.duracao());
        filmeExistente.setGenero(filmeDTO.genero());
        filmeExistente.setDataLancamento(filmeDTO.dataLancamento());
        filmeExistente.setNota(filmeDTO.nota());

        return filmeRepository.save(filmeExistente);
        
    }
}
