package com.github.julianomachadoo.vendas.service;

import com.github.julianomachadoo.vendas.domain.entity.Cliente;
import com.github.julianomachadoo.vendas.domain.repository.ClienteRepository;
import com.github.julianomachadoo.vendas.exceptions.DadosNaoEncontradosException;
import com.github.julianomachadoo.vendas.rest.dto.ClienteDTO;
import com.github.julianomachadoo.vendas.rest.form.ClienteForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO getClientById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) throw new DadosNaoEncontradosException("Cliente não encontrado");
        return new ClienteDTO(cliente.get());
    }

    public List<ClienteDTO> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAllByAtivoTrue();
        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    public ClienteDTO cadastrarCliente(ClienteForm clienteForm) {
        Cliente cliente = clienteRepository.save(new Cliente(clienteForm));
        return new ClienteDTO(cliente);
    }

    public void removerCliente(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) throw new DadosNaoEncontradosException("Cliente não encontrado");
        cliente.get().setAtivo(false);
    }
}
