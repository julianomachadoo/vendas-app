package com.github.julianomachadoo.vendas.rest.form;

public class ProdutoAtualizacaoForm {

    private String descricao;
    private Integer adicionarEstoque;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getAdicionarEstoque() {
        return adicionarEstoque;
    }

    public void setAdicionarEstoque(Integer adicionarEstoque) {
        this.adicionarEstoque = adicionarEstoque;
    }
}
