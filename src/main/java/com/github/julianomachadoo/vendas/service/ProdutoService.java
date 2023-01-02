package com.github.julianomachadoo.vendas.service;

import com.github.julianomachadoo.vendas.domain.entity.Produto;
import com.github.julianomachadoo.vendas.domain.repository.ProdutoRepository;
import com.github.julianomachadoo.vendas.exceptions.DadosNaoEncontradosException;
import com.github.julianomachadoo.vendas.rest.dto.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;


    public ProdutoDTO detalharProduto(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isEmpty()) throw new DadosNaoEncontradosException("Produto não encontrado");
        return new ProdutoDTO(produto.get());
    }
}
