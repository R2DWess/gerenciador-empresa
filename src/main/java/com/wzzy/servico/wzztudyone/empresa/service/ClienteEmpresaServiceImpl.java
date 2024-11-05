package com.wzzy.servico.wzztudyone.empresa.service;

import com.wzzy.servico.wzztudyone.empresa.model.EmpresaCliente;
import com.wzzy.servico.wzztudyone.empresa.model.ContratoClienteModel;
import com.wzzy.servico.wzztudyone.empresa.model.EmpresaClienteResumo;
import com.wzzy.servico.wzztudyone.empresa.model.MensagemEmpresaCliente;
import com.wzzy.servico.wzztudyone.empresa.utils.FileUtils;
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
public class ClienteEmpresaServiceImpl implements ClienteEmpresaService {

    private final MensagemEmpresaCliente mensagemEmpresaCliente;

    @Autowired
    private ClienteEmpresaRepository clienteEmpresaRepository;

    public ClienteEmpresaServiceImpl(MensagemEmpresaCliente mensagemEmpresaCliente) {
        this.mensagemEmpresaCliente = mensagemEmpresaCliente;
    }

    // Cadastrar Clientes
    @Override
    public ResponseEntity<?> cadastrar(EmpresaCliente empresaCliente) {
        MensagemEmpresaCliente mensagemEmpresaCliente = new MensagemEmpresaCliente();

        if (empresaCliente.getNomeCliente().isEmpty()) {
            mensagemEmpresaCliente.setMensagem("Nome inválido");
            return new ResponseEntity<>(mensagemEmpresaCliente, HttpStatus.BAD_REQUEST);
        } else if (empresaCliente.getEmailCliente().isEmpty()) {
            mensagemEmpresaCliente.setMensagem("Email inválido");
            return new ResponseEntity<>(mensagemEmpresaCliente, HttpStatus.BAD_REQUEST);
        } else if (empresaCliente.getTelefoneCliente().isEmpty()) {
            mensagemEmpresaCliente.setMensagem("Telefone inválido");
            return new ResponseEntity<>(mensagemEmpresaCliente, HttpStatus.BAD_REQUEST);
        } else if (empresaCliente.getCnjCliente().isEmpty()) {
            mensagemEmpresaCliente.setMensagem("CNJ inválido");
            return new ResponseEntity<>(mensagemEmpresaCliente, HttpStatus.BAD_REQUEST);
        } else if (empresaCliente.getEnderecoClienteModel().rua().isEmpty()) {
            mensagemEmpresaCliente.setMensagem("Endereço inválido");
            return new ResponseEntity<>(mensagemEmpresaCliente, HttpStatus.BAD_REQUEST);
        } else if (empresaCliente.getAreaAtuacaoCliente().isEmpty()) {
            mensagemEmpresaCliente.setMensagem("Área de atuação inválida");
            return new ResponseEntity<>(mensagemEmpresaCliente, HttpStatus.BAD_REQUEST);
        } else {
            clienteEmpresaRepository.save(empresaCliente);
            return new ResponseEntity<>(empresaCliente, HttpStatus.CREATED);
        }
    }

    // Mostrar Clientes
    @Override
    public List<EmpresaCliente> findAll() {
        return clienteEmpresaRepository.findAll();
    }

    // Mostrar cliente por Id
    @Override
    public Optional<EmpresaCliente> findByCodigoCliente(int codigoCliente) {
        return clienteEmpresaRepository.findByCodigoCliente(codigoCliente);
    }

    // Listar nomes dos clientes
    @Override
    public List<String> listarNomesClientes() {
        List<Object[]> resultados = clienteEmpresaRepository.findAllDadosCliente();
        return resultados.stream()
                .map(obj -> obj[0] + " - " + obj[1])
                .collect(Collectors.toList());
    }

    // UploadContrato
    @Override
    public ResponseEntity<String> uploadContrato(int codigoCliente, MultipartFile file) {
        Optional<EmpresaCliente> clienteOptional = clienteEmpresaRepository.findByCodigoCliente(codigoCliente);
        if (clienteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        EmpresaCliente empresaCliente = clienteOptional.get();
        ContratoClienteModel novoContratoClienteModel = new ContratoClienteModel(
                FileUtils.getFormato(file.getOriginalFilename()),
                file.getOriginalFilename(),
                LocalDate.now(),
                String.format("%.2f MB", (file.getSize() / (1024.0 * 1024.0)))
        );

        empresaCliente.setContrato(novoContratoClienteModel);
        clienteEmpresaRepository.save(empresaCliente);
        return ResponseEntity.ok("Contrato anexado com sucesso ao cliente!");
    }

    // Deletar Clientes por ID
    @Override
    public void deleteById(int codigoCliente) {
        clienteEmpresaRepository.deleteById(codigoCliente);
    }

    @Override
    public ResponseEntity<EmpresaClienteResumo> getClienteResumo(int codigoCliente) {
        Optional<EmpresaCliente> clienteOptional = clienteEmpresaRepository.findByCodigoCliente(codigoCliente);
        if (clienteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        EmpresaCliente cliente = clienteOptional.get();
        EmpresaClienteResumo resumo = new EmpresaClienteResumo(
                cliente.getNomeCliente(),
                cliente.getEmailCliente(),
                cliente.getTelefoneCliente(),
                cliente.getCnjCliente(),
                cliente.getEnderecoClienteModel().cep(),
                cliente.getNomeEmpresa(),
                cliente.getContratoClienteModel() != null
        );

        return ResponseEntity.ok(resumo);
    }
}