package com.wzzy.servico.wzztudyone.empresa.model;


public class SetorEmpresaCliente {

    private String nome;
    private String descricao;

    public SetorEmpresaCliente(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
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

}

