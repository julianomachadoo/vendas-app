package com.github.julianomachadoo.vendas.rest.form;

import jakarta.validation.constraints.NotNull;

public class ProdutoForm {

    private String nome;
    private String descricao;
    private String preco;
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
