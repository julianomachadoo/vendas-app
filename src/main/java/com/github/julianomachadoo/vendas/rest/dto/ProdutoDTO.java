package com.github.julianomachadoo.vendas.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.julianomachadoo.vendas.domain.entity.Produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProdutoDTO {

    @JsonIgnore
    private Long id;
    private String nome;
    private String descricao;
    private String preco;
    private LocalDateTime dataCadastro;
    private String categoria;
    private Integer estoque;

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = "R$ " + produto.getPreco();
        this.dataCadastro = produto.getDataCadastro();
        this.categoria = produto.getCategoria().toString();
        this.estoque = produto.getEstoque();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = "R$ " + preco;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
}
