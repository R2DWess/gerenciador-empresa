package com.wzzy.servico.wzztudyone.funcionario.model;

import org.springframework.stereotype.Component;

@Component
public class MensagemFuncionario {

    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
