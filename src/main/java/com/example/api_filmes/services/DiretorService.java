package com.example.api_filmes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.api_filmes.dto.DiretorDTO;
import com.example.api_filmes.entities.Diretor;
import com.example.api_filmes.exceptions.DiretorNaoEncontradoException;
import com.example.api_filmes.repositories.DiretorRepository;

@Service
public class DiretorService{
    private final DiretorRepository diretorRepository;

    public DiretorService(DiretorRepository diretorRepository) {
        this.diretorRepository = diretorRepository;
    }

    public List<Diretor> buscarTodos(){
        return diretorRepository.findAll();
    }

    public Diretor buscarPorId(Long id){
        return diretorRepository.findById(id)
        .orElseThrow(() -> new DiretorNaoEncontradoException(id));
    }

    public Diretor salvarDiretor(DiretorDTO diretorDTO){
        Diretor diretor = new Diretor();

        diretor.setNome(diretorDTO.nome());
        diretor.setDataNascimento(diretorDTO.dataNascimento());

        return diretorRepository.save(diretor);

    }

    public void deletarDiretor(Long id){
        if(!diretorRepository.existsById(id)){
            throw new DiretorNaoEncontradoException(id);
        }
        diretorRepository.deleteById(id);
    }

    public Diretor atualizarDiretor(Long id, DiretorDTO diretorDTO){
        Diretor diretorExistente = diretorRepository.findById(id).orElseThrow(() -> new DiretorNaoEncontradoException(id));

        diretorExistente.setNome(diretorDTO.nome());
        diretorExistente.setDataNascimento(diretorDTO.dataNascimento());
        return diretorRepository.save(diretorExistente);
    }
}