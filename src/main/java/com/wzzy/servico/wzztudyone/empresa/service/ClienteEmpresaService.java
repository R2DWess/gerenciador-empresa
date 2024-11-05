package com.wzzy.servico.wzztudyone.empresa.service;

import com.wzzy.servico.wzztudyone.empresa.model.EmpresaCliente;
import com.wzzy.servico.wzztudyone.empresa.model.EmpresaClienteResumo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ClienteEmpresaService {

    void deleteById(int codigoCliente);

    ResponseEntity<?> cadastrar(EmpresaCliente clientes);

    List<EmpresaCliente> findAll();

    Optional<EmpresaCliente> findByCodigoCliente(int codigoCliente);

    List<String> listarNomesClientes();

    ResponseEntity<String> uploadContrato(int codigoCliente, MultipartFile file);

    ResponseEntity<EmpresaClienteResumo> getClienteResumo(int codigoCliente);
}
