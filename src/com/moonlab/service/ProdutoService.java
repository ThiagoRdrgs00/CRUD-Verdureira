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
        double valorTotalGeral[] = new double[1];
        int quantidadeTotalGeral[] = new int[1];
        produtos.forEach(produto -> {
            //Por algum motivo, variaveis não funcionam dentro de uma lambda, e por algum outro motivo, vetores funcionam, por conta disso foi usado vetor
            quantidadeTotalGeral[0] += produto.getQuantidade(); //Faz a soma das quantidades
            valorTotalGeral[0] += (produto.getQuantidade() * produto.getValorUnitario()); //Faz a soma dos valores

            System.out.println("Nome: " + produto.getNome());
            System.out.println("Quantidade: " + produto.getQuantidade());
            System.out.println("Valor Unitário: " + produto.getValorUnitario());
            System.out.println("Valor Total Produto: " + produto.getQuantidade() * produto.getValorUnitario());
            System.out.println("-----------------------------------");
        });
        System.out.println("Quantidade Total Geral: " + quantidadeTotalGeral[0]);
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
        boolean repetir = true;
        ProdutoEntity produtoEditado = new ProdutoEntity();

        do {
            System.out.println("Qual opção deseja editar?");
            System.out.println("1 - Nome");
            System.out.println("2 - Quantidade");
            System.out.println("3 - Valor Unitário");
            System.out.println("0 - Encerar edição e salvar produto");
            int opcaoEditar = input.nextInt();

            switch (opcaoEditar) {
                case 1:
                    System.out.println("Informe o nome do produto: ");
                    input.nextLine();
                    String nome = input.nextLine();
                    produtoEditado = editarProdutoNome(produtoEntity, nome);
                    break;

                case 2:
                    System.out.println("Informe a quantidade do produto: ");
                    int quantidade = input.nextInt();
                    produtoEditado = editarProdutoQuantidade(produtoEntity, quantidade);
                    break;

                case 3:
                    System.out.print("Informe o valor unitário do produto: ");
                    double valorUnitario = input.nextDouble();
                    produtoEditado = editarProdutoValorUnitario(produtoEntity, valorUnitario);
                    break;

                case 0:
                    repetir = false;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (repetir) ;
        return produtoEditado;
    }

    public ProdutoEntity editarProdutoNome(ProdutoEntity produtoEntity, String nome) {
        produtoEntity.setNome(nome);
        return produtoEntity;
    }

    public ProdutoEntity editarProdutoQuantidade(ProdutoEntity produtoEntity, int quantidade) {
        produtoEntity.setQuantidade(quantidade);
        return produtoEntity;
    }

    public ProdutoEntity editarProdutoValorUnitario(ProdutoEntity produtoEntity, double valorUnitario) {
        produtoEntity.setValorUnitario(valorUnitario);
        return produtoEntity;
    }

    public ProdutoEntity removerProduto(int id, List<ProdutoEntity> produtos) {
        return produtos.remove(id);
    }
}