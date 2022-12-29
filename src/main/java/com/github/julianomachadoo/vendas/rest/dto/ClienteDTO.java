package com.github.julianomachadoo.vendas.rest.dto;

import com.github.julianomachadoo.vendas.domain.entity.Cliente;

public class ClienteDTO {
    private final String nome;
    private final String cpf;

    public ClienteDTO(Cliente cliente) {
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}

