package com.wzzy.servico.wzztudyone.empresa.model;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public record ContratoClienteModel(
        String formato,
        String nomeArquivo,
        LocalDate dataAnexo,
        String tamanhoArquivo
) {}