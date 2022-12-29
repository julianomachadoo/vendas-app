package com.github.julianomachadoo.vendas.rest.controller;

import com.github.julianomachadoo.vendas.domain.entity.Cliente;
import com.github.julianomachadoo.vendas.domain.repository.ClienteRepository;
import com.github.julianomachadoo.vendas.rest.dto.ClienteDTO;
import com.github.julianomachadoo.vendas.rest.form.ClienteForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClientById(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            ClienteDTO clienteDTO = new ClienteDTO(cliente.get());
            return ResponseEntity.ok().body(clienteDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<ClienteDTO> listarClientes() {
        List<Cliente> clienteList = clienteRepository.findAllByAtivoTrue();
        List<ClienteDTO> clienteDtoList = new ArrayList<>();
        clienteList.forEach(cliente -> clienteDtoList.add(new ClienteDTO(cliente)));
        return clienteDtoList;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteDTO> cadastroDeCliente(
            @RequestBody @Valid ClienteForm clienteForm) {

        Cliente cliente = clienteRepository.save(new Cliente(clienteForm));
        return ResponseEntity.ok().body(new ClienteDTO(cliente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> removerCliente(@PathVariable Long id) {
        Cliente cliente = clienteRepository.getReferenceById(id);
        cliente.setAtivo(false);
        return ResponseEntity.noContent().build();
    }

}
