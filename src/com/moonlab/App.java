package com.moonlab;

import com.moonlab.controller.ProdutoController;
import com.moonlab.entity.ProdutoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<ProdutoEntity> produtos = new ArrayList<>();

        boolean repetir = true;
        int opcao;
        String nome;
        int quantidade;
        double valorUnitario;
        int id;

        ProdutoController produtoController = new ProdutoController();

        do{
            System.out.println("---MENU---");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produto");
            System.out.println("3 - Buscar produto");
            System.out.println("4 - Editar produto");
            System.out.println("5 - Remover produto");
            System.out.println("0 - Encerrar a aplicação");
            System.out.print("Informe a opção desejada: ");
            opcao = input.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("---Cadastrar---");
                    System.out.print("Informe o nome do produto: ");
                    input.nextLine();
                    nome = input.nextLine();
                    System.out.println("Informe a quantidade do produto: ");
                    quantidade = input.nextInt();
                    System.out.print("Informe o valor unitário do produto: ");
                    valorUnitario = input.nextDouble();

                    produtos.add(produtoController.cadastrarProduto(nome, quantidade, valorUnitario));
                    break;

                case 2:
                    System.out.println("---Listar---");
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto encontrado!");
                        break;
                    }

                    produtoController.listarProduto(produtos);
                    break;

                case 3:
                    System.out.println("---Buscar---");
                    System.out.println("Informe o id do produto: ");
                    id = input.nextInt();
                    if (id >= produtos.size() || id < 0) {
                        System.out.println("Produto não encontrado!");
                        break;
                    }

                    produtoController.buscarProduto(id, produtos);
                    break;

                case 4:
                    System.out.println("---Editar---");
                    System.out.println("Informe o id do produto: ");
                    id = input.nextInt();
                    if (id >= produtos.size() || id < 0) {
                        System.out.println("Produto não encontrada!");
                        break;
                    }

                    ProdutoEntity produtoEntity = produtos.get(id);
                    ProdutoEntity produtoEntityEditado = produtoController.editarProduto(produtoEntity);
                    produtos.set(id, produtoEntityEditado);
                    break;

                case 5:
                    System.out.println("---Remover---");
                    System.out.println("Informe o id do produto: ");
                    id = input.nextInt();
                    if (id >= produtos.size() || id < 0) {
                        System.out.println("Produto não encontrado!");
                        break;
                    }

                    produtoController.removerProduto(id, produtos);
                    break;

                case 0:
                    repetir = false;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (repetir);

        System.out.println("Bye Bye");
        input.close();

    }
}
