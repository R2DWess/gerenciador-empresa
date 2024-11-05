package com.wzzy.servico.wzztudyone.funcionario.model;

import com.wzzy.servico.wzztudyone.funcionario.model.enums.SetorFuncionarioTipo;

public class SetorFuncionario {

    private String nome;
    private String descricao;
    private SetorFuncionarioTipo tipo;

    public SetorFuncionario(String nome, String descricao, SetorFuncionarioTipo tipo) {
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    // Getters e setters
    public String getNome() {
        return nome; }

    public void setNome(String nome) {
        this.nome = nome; }

    public String getDescricao() {
        return descricao; }

    public void setDescricao(String descricao) {
        this.descricao = descricao; }

    public SetorFuncionarioTipo getTipo() {
        return tipo; }

    public void setTipo(SetorFuncionarioTipo tipo) {
        this.tipo = tipo; }
}

