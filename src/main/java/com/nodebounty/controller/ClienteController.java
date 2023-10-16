package com.nodebounty.controller;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nodebounty.domain.cliente.Cliente;
import com.nodebounty.domain.cliente.ClienteRepository;
import com.nodebounty.domain.cliente.DadosAtualizacaoCliente;
import com.nodebounty.domain.cliente.DadosCadastroCliente;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {
    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public ResponseEntity<List<Cliente>> GetAllClientes() {
        List<Cliente> allClientes = repository.findAll();
        return ResponseEntity.ok(allClientes);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> registerClientes(@RequestBody @Valid DadosCadastroCliente data) {
        Cliente newCliente = new Cliente(data);
        repository.save(newCliente);
        System.out.print(data);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Void> updateCliente(@RequestBody @Valid DadosAtualizacaoCliente data) {
        Optional<Cliente> optionalCliente = repository.findById(data.id());

        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            cliente.atualizarDados(data);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
