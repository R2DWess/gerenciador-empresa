package com.wzzy.servico.wzztudyone.funcionario.model;

import jakarta.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class ContratoFuncionario {

    private String formato;
    private String nomeArquivo;
    private LocalDate dataAnexo;
    private String tamanhoArquivo;

    public ContratoFuncionario() {}

    public ContratoFuncionario(String formato, String nomeArquivo, LocalDate dataAnexo, String tamanhoArquivo) {
        this.formato = formato;
        this.nomeArquivo = nomeArquivo;
        this.dataAnexo = dataAnexo;
        this.tamanhoArquivo = tamanhoArquivo;
    }

    // Getters e Setters
    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public LocalDate getDataAnexo() {
        return dataAnexo;
    }

    public void setDataAnexo(LocalDate dataAnexo) {
        this.dataAnexo = dataAnexo;
    }

    public String getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(String tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }
}
