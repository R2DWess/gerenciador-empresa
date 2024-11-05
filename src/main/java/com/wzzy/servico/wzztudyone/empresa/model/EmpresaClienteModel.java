package com.wzzy.servico.wzztudyone.empresa.model;

import jakarta.persistence.Embeddable;

@Embeddable
public record EmpresaClienteModel(

     String nomeEmpresa,
     String descricaoEmpresa
) {}

