package com.github.julianomachadoo.vendas.rest.controller;

import com.github.julianomachadoo.vendas.domain.entity.Cliente;
import com.github.julianomachadoo.vendas.domain.repository.ClienteRepository;
import com.github.julianomachadoo.vendas.rest.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
