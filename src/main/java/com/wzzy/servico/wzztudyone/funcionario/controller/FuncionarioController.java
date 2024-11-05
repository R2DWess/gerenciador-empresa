package com.wzzy.servico.wzztudyone.funcionario.controller;

import com.wzzy.servico.wzztudyone.funcionario.model.Funcionario;
import com.wzzy.servico.wzztudyone.funcionario.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/cadastrar-funcionario")
    public ResponseEntity<?> cadastrarCliente(@Valid @RequestBody Funcionario funcionario) {
        return funcionarioService.cadastrar(funcionario);
    }

    @GetMapping("/funcionario")
    public ResponseEntity<List<Funcionario>> listarClientes() {
        List<Funcionario> funcionarios = funcionarioService.findAll();
        return ResponseEntity.ok(funcionarios);
    }

    @DeleteMapping("/funcionario/{codigoCliente}")
    public void removerClientes(@PathVariable int codigoFuncionario){
        funcionarioService.deleteById(codigoFuncionario);
    }

    @GetMapping("/funcionario/nomes")
    public ResponseEntity<List<String>> listarNomeClientes() {
        List<String> nomeFuncionario = funcionarioService.listarNomesFuncionarios();
        return ResponseEntity.ok(nomeFuncionario);
    }

    @PostMapping("/funcionario/{codigoCliente}/contrato")
    public ResponseEntity<String> uploadContrato(@PathVariable int codigoFuncionario,
                                                 @RequestParam("file") MultipartFile file) {
        return funcionarioService.uploadContratoFuncionario(codigoFuncionario, file);
    }
}
