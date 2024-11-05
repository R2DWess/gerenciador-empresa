package com.wzzy.servico.wzztudyone.empresa.model;

import org.springframework.stereotype.Component;

@Component
public class MensagemEmpresaCliente {

    private String mensagem;

    public MensagemEmpresaCliente() {
        this.mensagem = "Mensagem padrão"; // valor padrão, se necessário
    }

    // Construtor para definir a mensagem, se necessário
    public MensagemEmpresaCliente(String mensagem) {
        this.mensagem = mensagem;
    }

    // Getters e Setters
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
