package com.wzzy.servico.wzztudyone.empresa.model;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public record EnderecoClienteModel(
        String rua,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep
) {
    public EnderecoClienteModel {
        // Validações simples no construtor compacto
        Objects.requireNonNull(rua, "Rua é obrigatória");
        Objects.requireNonNull(numero, "Número é obrigatório");
        Objects.requireNonNull(bairro, "Bairro é obrigatório");
        Objects.requireNonNull(cidade, "Cidade é obrigatória");
        Objects.requireNonNull(estado, "Estado é obrigatório");
        Objects.requireNonNull(cep, "CEP é obrigatório");

        if (!estado.matches("^[A-Z]{2}$")) {
            throw new IllegalArgumentException("Estado deve ter 2 letras maiúsculas");
        }
        if (!cep.matches("^\\d{5}-\\d{3}$")) {
            throw new IllegalArgumentException("CEP inválido, formato esperado: 00000-000");
        }
    }
}
