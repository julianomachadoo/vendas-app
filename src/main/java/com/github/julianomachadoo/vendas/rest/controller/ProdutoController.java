package com.github.julianomachadoo.vendas.rest.controller;

import com.github.julianomachadoo.vendas.rest.dto.ProdutoDTO;
import com.github.julianomachadoo.vendas.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/{id}")
    public ProdutoDTO detalharProduto(@PathVariable Long id) {
        return produtoService.detalharProduto(id);
    }

}
