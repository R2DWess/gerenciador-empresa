package com.wzzy.servico.wzztudyone.funcionario.service;

import com.wzzy.servico.wzztudyone.funcionario.model.Funcionario;
import com.wzzy.servico.wzztudyone.funcionario.model.ContratoFuncionario;
import com.wzzy.servico.wzztudyone.funcionario.model.MensagemFuncionario;
import com.wzzy.servico.wzztudyone.funcionario.utils.FuncionarioFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private final MensagemFuncionario mensagemFuncionario;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioServiceImpl(MensagemFuncionario mensagemFuncionario) {
        this.mensagemFuncionario = mensagemFuncionario;
    }
    // Cadastrar Clientes
    @Override
    public ResponseEntity<?> cadastrar(Funcionario funcionario) {
        if (funcionario.getNomeFuncionario().isEmpty()) {
            mensagemFuncionario.setMensagem("Nome inválido");
            return new ResponseEntity<>(mensagemFuncionario, HttpStatus.BAD_REQUEST);
        } else if (funcionario.getCnjFuncionario().isEmpty()) {
            mensagemFuncionario.setMensagem("Cnpj inválido");
            return new ResponseEntity<>(mensagemFuncionario, HttpStatus.BAD_REQUEST);
        } else if (funcionario.getEmailFuncionario().isEmpty()) {
            mensagemFuncionario.setMensagem("Email inválido");
            return new ResponseEntity<>(mensagemFuncionario, HttpStatus.BAD_REQUEST);
        } else if (funcionario.getTelefoneFuncionario().isEmpty()) {
            mensagemFuncionario.setMensagem("Telefone inválido");
            return new ResponseEntity<>(mensagemFuncionario, HttpStatus.BAD_REQUEST);
        } else if (funcionario.getEnderecoCliente().equals("")) {
            mensagemFuncionario.setMensagem("Endereco inválido");
            return new ResponseEntity<>(mensagemFuncionario, HttpStatus.BAD_REQUEST);
        } else if (funcionario.getAreaAtuacaoCliente().isEmpty()) {
            mensagemFuncionario.setMensagem("Endereco inválido");
            return new ResponseEntity<>(mensagemFuncionario, HttpStatus.BAD_REQUEST);
        } else {
            funcionarioRepository.save(funcionario);
            return new ResponseEntity<>(funcionario, HttpStatus.CREATED);
        }

    }

    // Mostrar Clientes
    @Override
    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    // Mostrar cliente por Id
    @Override
    public Optional<Funcionario> findByCodigoFuncionario(int codigoCliente) {
        return funcionarioRepository.findByCodigoFuncionario(codigoCliente);
    }

    // Listar nomes dos clientes
    @Override
    public List<String> listarNomesFuncionarios() {
        List<Object[]> resultados = funcionarioRepository.findAllDadosFuncionario();
        return resultados.stream()
                .map(obj -> obj[0] + " - " + obj[1])
                .collect(Collectors.toList());
    }

    // UploadContrato
    @Override
    public ResponseEntity<String> uploadContratoFuncionario(int codigoCliente, MultipartFile file) {
        Optional<Funcionario> clienteOptional = funcionarioRepository.findByCodigoFuncionario(codigoCliente);
        if (clienteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Funcionario funcionario = clienteOptional.get();
        ContratoFuncionario novoContratoFuncionario = new ContratoFuncionario(
                FuncionarioFileUtils.getFormato(file.getOriginalFilename()),
                file.getOriginalFilename(),
                LocalDate.now(),
                String.format("%.2f MB", (file.getSize() / (1024.0 * 1024.0)))
        );

        funcionario.setContrato(novoContratoFuncionario);
        funcionarioRepository.save(funcionario);
        return ResponseEntity.ok("Contrato anexado com sucesso ao cliente!");
    }

    // Deletar Clientes por ID
    @Override
    public void deleteById(int codigoCliente) {
        funcionarioRepository.deleteById(codigoCliente);
    }
}