package com.wzzy.servico.wzztudyone.funcionario.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wzzy.servico.wzztudyone.funcionario.model.enums.SetorFuncionarioTipo;
import com.wzzy.servico.wzztudyone.funcionario.model.serielizer.TelefoneFuncionarioSerializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity(name = "EntidadeFuncionario")
@Table(name = "funcionario")
public class Funcionario {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoFuncionario;

    @NotEmpty(message = "Informe um nome")
    private String nomeFuncionario;

    @Email(message = "Informe um email válido!")
    private String emailFuncionario;

    @Pattern(regexp = "^\\d{11}$", message = "O número de telefone deve ter exatamente 11 dígitos.")
    @JsonSerialize(using = TelefoneFuncionarioSerializer.class)
    private String telefoneFuncionario;

    @Size(min = 9, max = 9, message = "O campo CNJ deve ter exatamente 9 caracteres.")
    private String cnjFuncionario;

    @Embedded
    private EnderecoFuncionario enderecoFuncionario;

    @Enumerated(EnumType.STRING)
    private SetorFuncionarioTipo setorFuncionario;

    @Embedded
    private ContratoFuncionario contratoFuncionario;

    private String areaAtuacaoCliente;

    // Construtor completo (sem o campo codigoCliente, que é gerado automaticamente)
    public Funcionario(String nomeFuncionario,
                       String emailFuncionario,
                       String telefoneFuncionario,
                       String cnjFuncionario,
                       EnderecoFuncionario enderecoFuncionario,
                       String areaAtuacaoCliente,
                       ContratoFuncionario contratoFuncionario,
                       SetorFuncionarioTipo setorFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
        this.emailFuncionario = emailFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
        this.cnjFuncionario = cnjFuncionario;
        this.enderecoFuncionario = enderecoFuncionario;
        this.areaAtuacaoCliente = areaAtuacaoCliente;
        this.contratoFuncionario = contratoFuncionario;
        this.setorFuncionario = setorFuncionario;
    }

    // Construtor vazio para JPA
    public Funcionario() {}

    // Getters e Setters
    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getEmailFuncionario() {
        return emailFuncionario;
    }

    public void setEmailFuncionario(String emailFuncionario) {
        this.emailFuncionario = emailFuncionario;
    }

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public void setTelefoneFuncionario(String telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }

    public String getCnjFuncionario() {
        return cnjFuncionario;
    }

    public void setCnjFuncionario(String cnjFuncionario) {
        this.cnjFuncionario = cnjFuncionario;
    }

    public EnderecoFuncionario getEnderecoCliente() {
        return enderecoFuncionario;
    }

    public void setEnderecoCliente(EnderecoFuncionario enderecoFuncionario) {
        this.enderecoFuncionario = enderecoFuncionario;
    }

    public ContratoFuncionario getContrato() {
        return contratoFuncionario;
    }

    public void setContrato(ContratoFuncionario contratoFuncionario) {
        this.contratoFuncionario = contratoFuncionario;
    }

    public String getAreaAtuacaoCliente() {
        return areaAtuacaoCliente;
    }

    public void setAreaAtuacaoCliente(String areaAtuacaoCliente) {
        this.areaAtuacaoCliente = areaAtuacaoCliente;
    }

    public SetorFuncionarioTipo getSetorFuncionario() {
        return setorFuncionario;
    }

    public void setSetorFuncionario(SetorFuncionarioTipo setorFuncionario) {
        this.setorFuncionario = setorFuncionario;
    }
}
