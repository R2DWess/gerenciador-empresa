package com.wzzy.servico.wzztudyone.funcionario.service;

import com.wzzy.servico.wzztudyone.funcionario.model.Funcionario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface FuncionarioService {

    void deleteById(int codigoFuncionario);

    ResponseEntity<?> cadastrar(Funcionario funcionario);

    List<Funcionario> findAll();

    Optional<Funcionario> findByCodigoFuncionario(int codigoCliente);

    List<String> listarNomesFuncionarios();

    ResponseEntity<String> uploadContratoFuncionario(int codigoCliente, MultipartFile file);

}
