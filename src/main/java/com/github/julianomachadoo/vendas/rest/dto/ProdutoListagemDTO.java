package com.github.julianomachadoo.vendas.rest.dto;

import com.github.julianomachadoo.vendas.domain.entity.Produto;

public class ProdutoListagemDTO {

    private String nome;
    private String preco;
    private String categoria;

    public ProdutoListagemDTO(Produto produto) {
        this.nome = produto.getNome();
        this.preco = "R$ " + produto.getPreco();
        this.categoria = produto.getCategoria().toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
