package com.example.api_filmes.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record FilmeDTO(

    @NotBlank String nome,
    @Positive Integer duracao,
    @NotBlank String genero,
    @NotNull LocalDate dataLancamento,
    @PositiveOrZero @Max(10) Double nota
){}
