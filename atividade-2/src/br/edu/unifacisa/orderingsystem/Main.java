package br.edu.unifacisa.orderingsystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GerenciamentoPedidos gerenciamento = new GerenciamentoPedidos();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            // Exibição do menu
            System.out.println("\n===== Sistema de Gerenciamento de Pedidos =====");
            System.out.println("1. Adicionar Pedido");
            System.out.println("2. Processar Próximo Pedido");
            System.out.println("3. Visualizar Pedidos na Fila");
            System.out.println("4. Remover Pedido Cancelado");
            System.out.println("5. Atualizar Prioridade do Pedido");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            // Leitura da opção escolhida
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    // Adicionar novo pedido
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Digite a descrição do pedido: ");
                    String descricaoPedido = scanner.nextLine();
                    System.out.print("Digite a prioridade do pedido (0-10): ");
                    int prioridade = scanner.nextInt();
                    System.out.print("O cliente é VIP? (true/false): ");
                    boolean isVip = scanner.nextBoolean();
                    gerenciamento.adicionarPedido(nomeCliente, descricaoPedido, prioridade, isVip);
                    System.out.println("Pedido adicionado com sucesso!");
                    break;

                case 2:
                    // Processar próximo pedido
                    Pedido pedidoProcessado = gerenciamento.processarProximoPedido();
                    if (pedidoProcessado != null) {
                        System.out.println("Processando pedido: " + pedidoProcessado);
                    } else {
                        System.out.println("Nenhum pedido na fila.");
                    }
                    break;

                case 3:
                    // Visualizar pedidos na fila
                    System.out.println("Pedidos na fila:");
                    gerenciamento.visualizarPedidos();
                    break;

                case 4:
                    // Remover pedido cancelado
                    System.out.print("Digite o nome do cliente cujo pedido será cancelado: ");
                    String nomeCancelado = scanner.nextLine();
                    Pedido pedidoCancelado = gerenciamento.buscarPedidoPorNome(nomeCancelado);
                    if (pedidoCancelado != null) {
                        gerenciamento.removerPedidoCancelado(pedidoCancelado);
                        System.out.println("Pedido cancelado com sucesso!");
                    } else {
                        System.out.println("Pedido não encontrado.");
                    }
                    break;

                case 5:
                    // Atualizar prioridade do pedido
                    System.out.print("Digite o nome do cliente cujo pedido será atualizado: ");
                    String nomeAtualizar = scanner.nextLine();
                    Pedido pedidoAtualizar = gerenciamento.buscarPedidoPorNome(nomeAtualizar);
                    if (pedidoAtualizar != null) {
                        System.out.print("Digite a nova prioridade: ");
                        int novaPrioridade = scanner.nextInt();
                        gerenciamento.atualizarPrioridade(pedidoAtualizar, novaPrioridade);
                        System.out.println("Prioridade atualizada com sucesso!");
                    } else {
                        System.out.println("Pedido não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
