package com.github.julianomachadoo.vendas.rest.form;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class ClienteForm {

    @NotBlank @Length(min = 3, max = 100)
    private String nome;
    @NotBlank @Length(min = 14, max = 14)
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
