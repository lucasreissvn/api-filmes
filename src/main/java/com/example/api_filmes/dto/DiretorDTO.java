package com.example.api_filmes.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DiretorDTO(
    @NotBlank String nome,
    @NotNull LocalDate dataNascimento
){}