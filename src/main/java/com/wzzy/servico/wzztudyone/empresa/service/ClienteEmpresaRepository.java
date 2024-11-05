package com.wzzy.servico.wzztudyone.empresa.service;

import com.wzzy.servico.wzztudyone.empresa.model.EmpresaCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteEmpresaRepository extends JpaRepository<EmpresaCliente, Integer> {

    Optional<EmpresaCliente> findByCodigoCliente(int codigoCliente);

    @Query("SELECT c.nomeCliente, c.nomeEmpresa FROM EmpresaCliente c")
    List<Object[]> findAllDadosCliente();
}