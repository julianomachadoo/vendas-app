package com.github.julianomachadoo.vendas.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.julianomachadoo.vendas.domain.entity.Cliente;

public class ClienteDTO {
    @JsonIgnore
    private Long id;
    private final String nome;
    private final String cpf;

    public ClienteDTO(Cliente cliente) {
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.id = cliente.getId();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

