package com.wzzy.servico.wzztudyone.empresa.model;

public class EmpresaClienteResumo {

    private String nomeCliente;
    private String emailCliente;
    private String telefoneCliente;
    private String cnjCliente;
    private String cep;
    private String nomeEmpresa;
    private boolean contrato;

    public EmpresaClienteResumo(String nomeCliente,
                                String emailCliente,
                                String telefoneCliente,
                                String cnjCliente,
                                String cep,
                                String nomeEmpresa,
                                boolean contrato) {
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.telefoneCliente = telefoneCliente;
        this.cnjCliente = cnjCliente;
        this.cep = cep;
        this.nomeEmpresa = nomeEmpresa;
        this.contrato = contrato;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getCnjCliente() {
        return cnjCliente;
    }

    public void setCnjCliente(String cnjCliente) {
        this.cnjCliente = cnjCliente;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public boolean isContrato() {
        return contrato;
    }

    public void setContrato(boolean contrato) {
        this.contrato = contrato;
    }
}
