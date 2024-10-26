package br.edu.unifacisa.listaencadeada;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Criação do Scanner para entrada do usuário
        ListaEncadeada<String> lista = new ListaEncadeada<>();  // Criação de uma lista de Strings
        int opcao;  // Variável para armazenar a escolha do usuário

        // Laço do menu que continua até a opção de saída (0)
        do {
            // Exibe o menu de opções
            System.out.println("\n--- MENU ---");
            System.out.println("1. Adicionar elemento no final");
            System.out.println("2. Adicionar elemento por índice");
            System.out.println("3. Remover elemento por índice");
            System.out.println("4. Obter elemento por índice");
            System.out.println("5. Definir elemento por índice");
            System.out.println("6. Verificar tamanho da lista");
            System.out.println("7. Verificar se a lista está vazia");
            System.out.println("8. Verificar se contém um elemento");
            System.out.println("9. Buscar índice de um elemento");
            System.out.println("10. Buscar último índice de um elemento");
            System.out.println("11. Listar todos os elementos");  
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();  // Lê a opção escolhida
            scanner.nextLine();  // Consumir nova linha

            // Estrutura de decisão para executar a opção escolhida
            switch (opcao) {
                case 1:  // Adicionar no final
                    System.out.print("Digite o elemento a ser adicionado no final: ");
                    String elemento = scanner.nextLine();
                    lista.add(elemento);
                    System.out.println("Elemento adicionado no final.");
                    break;

                case 2:  // Adicionar por índice
                    System.out.print("Digite o índice: ");
                    int indexAdd = scanner.nextInt();
                    scanner.nextLine();  // Consumir nova linha
                    System.out.print("Digite o elemento a ser adicionado: ");
                    String elementoAdd = scanner.nextLine();
                    try {
                        lista.add(indexAdd, elementoAdd);
                        System.out.println("Elemento adicionado no índice " + indexAdd);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Erro: Índice fora do limite.");
                    }
                    break;

                case 3:  // Remover por índice
                    System.out.print("Digite o índice do elemento a ser removido: ");
                    int indexRemove = scanner.nextInt();
                    scanner.nextLine();  // Consumir nova linha
                    try {
                        String removido = lista.remove(indexRemove);
                        System.out.println("Elemento removido: " + removido);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Erro: Índice fora do limite.");
                    }
                    break;

                case 4:  // Obter elemento por índice
                    System.out.print("Digite o índice do elemento a ser obtido: ");
                    int indexGet = scanner.nextInt();
                    scanner.nextLine();  // Consumir nova linha
                    try {
                        String valor = lista.get(indexGet);
                        System.out.println("Elemento no índice " + indexGet + ": " + valor);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Erro: Índice fora do limite.");
                    }
                    break;

                case 5:  // Definir valor em um índice
                    System.out.print("Digite o índice do elemento a ser atualizado: ");
                    int indexSet = scanner.nextInt();
                    scanner.nextLine();  // Consumir nova linha
                    System.out.print("Digite o novo valor: ");
                    String novoValor = scanner.nextLine();
                    try {
                        lista.set(indexSet, novoValor);
                        System.out.println("Elemento no índice " + indexSet + " atualizado para " + novoValor);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Erro: Índice fora do limite.");
                    }
                    break;

                case 6:  // Verificar tamanho da lista
                    System.out.println("Tamanho da lista: " + lista.size());
                    break;

                case 7:  // Verificar se a lista está vazia
                    if (lista.isEmpty()) {
                        System.out.println("A lista está vazia.");
                    } else {
                        System.out.println("A lista não está vazia.");
                    }
                    break;

                case 8:  // Verificar se contém um elemento
                    System.out.print("Digite o elemento a ser verificado: ");
                    String elementoCheck = scanner.nextLine();
                    if (lista.contains(elementoCheck)) {
                        System.out.println("A lista contém o elemento.");
                    } else {
                        System.out.println("A lista não contém o elemento.");
                    }
                    break;

                case 9:  // Buscar índice de um elemento
                    System.out.print("Digite o elemento para buscar o índice: ");
                    String elementoIndex = scanner.nextLine();
                    int index = lista.indexOf(elementoIndex);
                    if (index != -1) {
                        System.out.println("Índice do elemento: " + index);
                    } else {
                        System.out.println("Elemento não encontrado.");
                    }
                    break;

                case 10:  // Buscar último índice de um elemento
                    System.out.print("Digite o elemento para buscar o último índice: ");
                    String elementoLastIndex = scanner.nextLine();
                    int lastIndex = lista.lastIndexOf(elementoLastIndex);
                    if (lastIndex != -1) {
                        System.out.println("Último índice do elemento: " + lastIndex);
                    } else {
                        System.out.println("Elemento não encontrado.");
                    }
                    break;

                case 11:  // Listar todos os elementos
                    System.out.println("Elementos da lista:");
                    for (int i = 0; i < lista.size(); i++) {
                        System.out.println("Índice " + i + ": " + lista.get(i));
                    }
                    break;

                case 0:  // Sair
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();  // Fecha o Scanner
    }
}
