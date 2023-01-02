package com.github.julianomachadoo.vendas.service;

import com.github.julianomachadoo.vendas.domain.entity.Categoria;
import com.github.julianomachadoo.vendas.domain.entity.Produto;
import com.github.julianomachadoo.vendas.domain.repository.CategoriaRepository;
import com.github.julianomachadoo.vendas.domain.repository.ProdutoRepository;
import com.github.julianomachadoo.vendas.exceptions.DadosInvalidosException;
import com.github.julianomachadoo.vendas.exceptions.DadosNaoEncontradosException;
import com.github.julianomachadoo.vendas.rest.dto.ProdutoDTO;
import com.github.julianomachadoo.vendas.rest.dto.ProdutoListagemDTO;
import com.github.julianomachadoo.vendas.rest.form.ProdutoAtualizacaoForm;
import com.github.julianomachadoo.vendas.rest.form.ProdutoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private static CategoriaRepository categoriaRepository;

    public ProdutoService(CategoriaRepository categoriaRepository) {
        ProdutoService.categoriaRepository = categoriaRepository;
    }

    public ProdutoDTO detalharProduto(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isEmpty()) throw new DadosNaoEncontradosException("Produto não encontrado");
        return new ProdutoDTO(produto.get());
    }
    public List<ProdutoListagemDTO> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream().map(ProdutoListagemDTO::new).collect(Collectors.toList());
    }

    public ProdutoDTO cadastrarProduto(ProdutoForm produtoForm) {
        Produto produto = produtoRepository.save(registrarFormulario(produtoForm));
        return new ProdutoDTO(produto);
    }

    public ProdutoDTO atualizaProduto(ProdutoAtualizacaoForm produtoAtualizacaoForm, Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isEmpty()) throw new DadosNaoEncontradosException("Produto não encontrado");
        if (produtoAtualizacaoForm.getDescricao() != null)
            produto.get().setDescricao(produtoAtualizacaoForm.getDescricao());
        if (produtoAtualizacaoForm.getAdicionarEstoque() != null) {
            produto.get().adicionarEstoque(produtoAtualizacaoForm.getAdicionarEstoque());
        }
        return new ProdutoDTO(produto.get());
    }

    public static Categoria encontrarCategoria(String categoriaNome) {
        Optional<Categoria> categoria = categoriaRepository.findByNome(categoriaNome.toUpperCase());
        if (categoria.isEmpty()) throw new DadosNaoEncontradosException("Categoria não cadastrada");
        return categoria.get();
    }

    public Produto registrarFormulario(ProdutoForm produtoForm) {
        Produto produto = new Produto();
        produto.setNome(produtoForm.getNome());
        produto.setDescricao(produtoForm.getDescricao());
        produto.setCategoria(ProdutoService.encontrarCategoria(produtoForm.getCategoria()));
        produto.adicionarEstoque(produtoForm.getEstoque());
        try{
            produto.setPreco(new BigDecimal(produtoForm.getPreco()));
        } catch (NumberFormatException e) {
            throw new DadosInvalidosException("Preço inválido");
        }
        return produto;
    }
}
