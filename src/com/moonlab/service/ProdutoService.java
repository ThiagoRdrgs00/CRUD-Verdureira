package com.moonlab.service;

import com.moonlab.entity.ProdutoEntity;

import java.util.List;
import java.util.Scanner;

public class ProdutoService {
    Scanner input = new Scanner(System.in);
    public ProdutoEntity cadastrarProduto(String nome, int quantidade, double valorUnitario) {
        ProdutoEntity produtoEntity = new ProdutoEntity();

        produtoEntity.setNome(nome);
        produtoEntity.setQuantidade(quantidade);
        produtoEntity.setValorUnitario(valorUnitario);

        return produtoEntity;
    }

    public void listarProduto(List<ProdutoEntity> produtos) {
        double[] valorTotalGeral = {0};
        produtos.forEach(produto -> {

            System.out.println("Nome: " + produto.getNome());
            System.out.println("Quantidade: " + produto.getQuantidade());
            System.out.println("Valor Unitário: " + produto.getValorUnitario());
            System.out.println("Valor Total Produto: " + produto.getQuantidade() * produto.getValorUnitario());
            System.out.println("-----------------------------------");
            valorTotalGeral[0] += (produto.getQuantidade() * produto.getValorUnitario());
        });
        System.out.println("Valor Total Geral: " + valorTotalGeral[0]);
        System.out.println();
    }

    public void buscarProduto(int id, List<ProdutoEntity> produtos) {
        ProdutoEntity produtoEntity = produtos.get(id);
        double valorTotal = produtoEntity.getQuantidade() * produtoEntity.getValorUnitario();

        System.out.println("Nome: " + produtoEntity.getNome());
        System.out.println("Quantidade: " + produtoEntity.getQuantidade());
        System.out.println("Valor Unitário: " + produtoEntity.getValorUnitario());
        System.out.println("Valor Total Produto: " + valorTotal);
        System.out.println();
    }

    public ProdutoEntity editarProduto(ProdutoEntity produtoEntity) {
        System.out.print("Informe o nome do produto: ");
        String nome = input.nextLine();
        System.out.println("Informe a quantidade do produto: ");
        int quantidade = input.nextInt();
        System.out.print("Informe o valor unitário do produto: ");
        double valorUnitario = input.nextDouble();

        produtoEntity.setNome(nome);
        produtoEntity.setQuantidade(quantidade);
        produtoEntity.setValorUnitario(valorUnitario);

        return produtoEntity;
    }

    public ProdutoEntity removerProduto(int id, List<ProdutoEntity> produtos) {
        return produtos.remove(id);
    }
}