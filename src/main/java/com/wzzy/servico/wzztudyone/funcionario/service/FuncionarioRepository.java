package com.wzzy.servico.wzztudyone.funcionario.service;

import com.wzzy.servico.wzztudyone.funcionario.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    Optional<Funcionario> findByCodigoFuncionario(int codigoFuncionario);

    @Query("SELECT c.nomeFuncionario, c.setorFuncionario FROM EntidadeFuncionario c")
    List<Object[]> findAllDadosFuncionario();

}
