package com.moonlab.controller;

import com.moonlab.entity.ProdutoEntity;
import com.moonlab.service.ProdutoService;

import java.util.List;

public class ProdutoController {

    ProdutoService produtoService = new ProdutoService();
    public ProdutoEntity cadastrarProduto(String nome, int quantidade, double valorUnitario){
        return produtoService.cadastrarProduto(nome, quantidade, valorUnitario);
    }

    public void listarProduto(List<ProdutoEntity> produtos) {
        produtoService.listarProduto(produtos);
    }

    public void buscarProduto(int id, List<ProdutoEntity> produtos) {
        produtoService.buscarProduto(id, produtos);
    }

    public ProdutoEntity editarProduto(ProdutoEntity produtoEntity) {
        return produtoService.editarProduto(produtoEntity);
    }

    public ProdutoEntity removerProduto(int id, List<ProdutoEntity> produtos) {
       return produtoService.removerProduto(id, produtos);
    }
}
