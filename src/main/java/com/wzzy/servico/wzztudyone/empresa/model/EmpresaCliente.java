package com.wzzy.servico.wzztudyone.empresa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wzzy.servico.wzztudyone.empresa.model.enums.Empresas;
import com.wzzy.servico.wzztudyone.empresa.model.serielizer.TelefoneEmpresaSerializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Map;

@Entity(name = "EmpresaCliente")
@Table(name = "empresas")
public class EmpresaCliente {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoCliente;

    @NotEmpty(message = "Informe um nome")
    private String nomeCliente;

    @Email(message = "Informe um email válido!")
    private String emailCliente;

    @Pattern(regexp = "^\\d{11}$", message = "O número de telefone deve ter exatamente 11 dígitos.")
    @JsonSerialize(using = TelefoneEmpresaSerializer.class)
    private String telefoneCliente;

    @Size(min = 9, max = 9, message = "O campo CNJ deve ter exatamente 9 caracteres.")
    private String cnjCliente;

    @Embedded
    private EnderecoClienteModel enderecoClienteModel;

    private String nomeEmpresa;
    private String descricaoEmpresa;

    @Embedded
    private ContratoClienteModel contratoClienteModel;

    private String areaAtuacaoCliente;

    private Empresas empresas;

    // Construtor completo (sem o campo codigoCliente, que é gerado automaticamente)
    public EmpresaCliente(String nomeCliente,
                          String emailCliente,
                          String telefoneCliente,
                          String cnjCliente,
                          EnderecoClienteModel enderecoClienteModel,
                          String areaAtuacaoCliente,
                          ContratoClienteModel contratoClienteModel,
                          String nomeEmpresa,
                          String descricaoEmpresa,
                          Empresas empresas) {
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.telefoneCliente = telefoneCliente;
        this.cnjCliente = cnjCliente;
        this.enderecoClienteModel = enderecoClienteModel;
        this.areaAtuacaoCliente = areaAtuacaoCliente;
        this.contratoClienteModel = contratoClienteModel;
        this.nomeEmpresa = nomeEmpresa;
        this.descricaoEmpresa = descricaoEmpresa;
        this.empresas = empresas;
    }

    // Construtor vazio para JPA
    public EmpresaCliente() {}

    // Getters e Setters
    public int getCodigoCliente() {
        return codigoCliente;
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

    public EnderecoClienteModel getEnderecoClienteModel() {
        return enderecoClienteModel;
    }

    public void setEnderecoClienteModel(EnderecoClienteModel enderecoClienteModel) {
        this.enderecoClienteModel = enderecoClienteModel;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getDescricaoEmpresa() {
        return descricaoEmpresa;
    }

    public void setDescricaoEmpresa(String descricaoEmpresa) {
        this.descricaoEmpresa = descricaoEmpresa;
    }

    public ContratoClienteModel getContratoClienteModel() {
        return contratoClienteModel;
    }

    public void setContratoClienteModel(ContratoClienteModel contratoClienteModel) {
        this.contratoClienteModel = contratoClienteModel;
    }

    public String getAreaAtuacaoCliente() {
        return areaAtuacaoCliente;
    }

    public void setAreaAtuacaoCliente(String areaAtuacaoCliente) {
        this.areaAtuacaoCliente = areaAtuacaoCliente;
    }

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

    // Add the missing setContrato method
    public void setContrato(ContratoClienteModel contratoClienteModel) {
        this.contratoClienteModel = contratoClienteModel;
    }

    // Unpack nested JSON property
    @JsonProperty("empresaClienteModel")
    private void unpackNested(Map<String, Object> empresaClienteModel) {
        this.nomeEmpresa = (String) empresaClienteModel.get("nomeEmpresa");
        this.descricaoEmpresa = (String) empresaClienteModel.get("descricaoEmpresa");
    }
}