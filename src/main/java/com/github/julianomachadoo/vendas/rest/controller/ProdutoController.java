package com.github.julianomachadoo.vendas.rest.controller;

import com.github.julianomachadoo.vendas.rest.dto.ProdutoDTO;
import com.github.julianomachadoo.vendas.rest.dto.ProdutoListagemDTO;
import com.github.julianomachadoo.vendas.rest.form.ProdutoAtualizacaoForm;
import com.github.julianomachadoo.vendas.rest.form.ProdutoForm;
import com.github.julianomachadoo.vendas.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/{id}")
    public ProdutoDTO detalharProduto(@PathVariable Long id) {
        return produtoService.detalharProduto(id);
    }

    @GetMapping
    public List<ProdutoListagemDTO> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoDTO> cadastroDeProduto(
            @RequestBody @Valid ProdutoForm produtoForm, UriComponentsBuilder uriBuilder) {
        ProdutoDTO produtoDTO = produtoService.cadastrarProduto(produtoForm);
        URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produtoDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(produtoDTO);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProdutoDTO> atualizaProduto(@RequestBody ProdutoAtualizacaoForm produtoAtualizacaoForm, @PathVariable Long id) {
        ProdutoDTO produtoDTO = produtoService.atualizaProduto(produtoAtualizacaoForm, id);
        return ResponseEntity.ok().body(produtoDTO);
    }

}
