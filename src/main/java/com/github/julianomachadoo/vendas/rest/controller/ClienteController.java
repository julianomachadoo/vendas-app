package com.github.julianomachadoo.vendas.rest.controller;

import com.github.julianomachadoo.vendas.rest.dto.ClienteDTO;
import com.github.julianomachadoo.vendas.rest.form.ClienteForm;
import com.github.julianomachadoo.vendas.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/{id}")
    public ClienteDTO getClientById(@PathVariable Long id) {
        return clienteService.getClientById(id);
    }

    @GetMapping
    public List<ClienteDTO> listarClientes() {
        return clienteService.listarClientes();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteDTO> cadastroDeCliente(
            @RequestBody @Valid ClienteForm clienteForm, UriComponentsBuilder uriBuilder) {

        ClienteDTO clienteDTO = clienteService.cadastrarCliente(clienteForm);
        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(clienteDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(clienteDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> removerCliente(@PathVariable Long id) {
        clienteService.removerCliente(id);
        return ResponseEntity.noContent().build();
    }

}
