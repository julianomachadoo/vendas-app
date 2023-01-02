package com.github.julianomachadoo.vendas.rest.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class ProdutoForm {

    @Length(max = 100) @NotBlank
    private String nome;
    @Length(max = 255)
    private String descricao;
    @NotBlank
    private String preco;
    @NotBlank
    private String categoria;
    @NotNull
    private Integer estoque;

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPreco() {
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getEstoque() {
        return estoque;
    }
}
