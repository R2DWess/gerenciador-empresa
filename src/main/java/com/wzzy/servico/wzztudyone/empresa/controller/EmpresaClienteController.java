package com.wzzy.servico.wzztudyone.empresa.controller;

import com.wzzy.servico.wzztudyone.empresa.model.EmpresaCliente;
import com.wzzy.servico.wzztudyone.empresa.model.EmpresaClienteResumo;
import com.wzzy.servico.wzztudyone.empresa.service.ClienteEmpresaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class EmpresaClienteController {

    @Autowired
    private ClienteEmpresaService clienteEmpresaService;

    @PostMapping("/cadastrar-cliente-empresa")
    public ResponseEntity<?> cadastrarCliente(@Valid @RequestBody EmpresaCliente empresaCliente) {
        return clienteEmpresaService.cadastrar(empresaCliente);
    }

    @GetMapping("/cliente-empresa")
    public ResponseEntity<List<EmpresaCliente>> listarClientes() {
        List<EmpresaCliente> empresaCliente = clienteEmpresaService.findAll();
        return ResponseEntity.ok(empresaCliente);
    }

    @DeleteMapping("/cliente-empresa/{codigoCliente}")
    public void removerClientes(@PathVariable int codigoCliente){
        clienteEmpresaService.deleteById(codigoCliente);
    }

    @GetMapping("/cliente-empresa/nomes")
    public ResponseEntity<List<String>> listarNomeClientes() {
        List<String> nomesClientes = clienteEmpresaService.listarNomesClientes();
        return ResponseEntity.ok(nomesClientes);
    }

    @PostMapping("/cliente-empresa/{codigoCliente}/contrato")
    public ResponseEntity<String> uploadContrato(@PathVariable int codigoCliente,
                                                 @RequestParam("file") MultipartFile file) {
        return clienteEmpresaService.uploadContrato(codigoCliente, file);
    }

    @GetMapping("/empresas-clientes-resumo/{codigoCliente}")
    public ResponseEntity<EmpresaClienteResumo> getClienteResumo(@PathVariable int codigoCliente) {
        return clienteEmpresaService.getClienteResumo(codigoCliente);
    }
}
