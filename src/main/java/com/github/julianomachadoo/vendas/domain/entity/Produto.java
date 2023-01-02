package com.github.julianomachadoo.vendas.domain.entity;

import com.github.julianomachadoo.vendas.rest.form.ProdutoForm;
import com.github.julianomachadoo.vendas.service.ProdutoService;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.SECONDS;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    private String descricao;
    @Column(name = "preco_unitario")
    private BigDecimal preco;
    private LocalDateTime dataCadastro = LocalDateTime.now().truncatedTo(SECONDS);
    @ManyToOne
    private Categoria categoria;

    public Produto() {
    }

    public Produto(ProdutoForm produtoForm) {
        this.nome = produtoForm.getNome();
        this.descricao = produtoForm.getDescricao();
        this.preco = new BigDecimal(produtoForm.getPreco());
        this.categoria = ProdutoService.encontrarCategoria(produtoForm.getCategoria());
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
