package com.example.api_filmes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.api_filmes.dto.FilmeDTO;
import com.example.api_filmes.entities.Diretor;
import com.example.api_filmes.entities.Filme;
import com.example.api_filmes.exceptions.DiretorNaoEncontradoException;
import com.example.api_filmes.exceptions.FilmeNaoEncontradoException;
import com.example.api_filmes.repositories.DiretorRepository;
import com.example.api_filmes.repositories.FilmeRepository;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;
    private final DiretorRepository diretorRepository;

    public FilmeService(FilmeRepository filmeRepository,DiretorRepository diretorRepository){
        this.filmeRepository=filmeRepository;
        this.diretorRepository=diretorRepository;
    }

    public List<Filme>buscarTodos(){
        return filmeRepository.findAll();
    }

    public Filme buscarPorId(Long id){
        return filmeRepository.findById(id)
        .orElseThrow(() -> new FilmeNaoEncontradoException(id));
    }

    public Filme salvarFilme(FilmeDTO filmeDTO){
        Diretor diretor = diretorRepository.findById(filmeDTO.idDiretor())
        .orElseThrow(() -> new DiretorNaoEncontradoException(filmeDTO.idDiretor()));

        Filme filme = new Filme();

        filme.setNome(filmeDTO.nome());
        filme.setDuracao(filmeDTO.duracao());
        filme.setGenero(filmeDTO.genero());
        filme.setDataLancamento(filmeDTO.dataLancamento());
        filme.setNota(filmeDTO.nota());
        filme.setDiretor(diretor);

        return filmeRepository.save(filme);
    }

    public void deletarFilme(Long id) {
        if (!filmeRepository.existsById(id)) {
            throw new FilmeNaoEncontradoException(id);
        }

        filmeRepository.deleteById(id);
    }

    public Filme atualizarFilme(Long id, FilmeDTO filmeDTO){

        Filme filmeExistente = filmeRepository.findById(id)
        .orElseThrow(() -> new FilmeNaoEncontradoException(id));
        
        Diretor diretor = diretorRepository.findById(filmeDTO.idDiretor())
        .orElseThrow(() -> new DiretorNaoEncontradoException(filmeDTO.idDiretor()));

        filmeExistente.setNome(filmeDTO.nome());
        filmeExistente.setDuracao(filmeDTO.duracao());
        filmeExistente.setGenero(filmeDTO.genero());
        filmeExistente.setDataLancamento(filmeDTO.dataLancamento());
        filmeExistente.setNota(filmeDTO.nota());
        filmeExistente.setDiretor(diretor);

        return filmeRepository.save(filmeExistente);
        
    }
}
