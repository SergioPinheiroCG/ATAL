package br.com.unifacisa.binaryMatrix;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int input = -1;
        BinaryMatrix tree = new BinaryMatrix(100); // Inicializa a árvore binária com 100 posições

        while (input != 0) {
            String result = MenuMatrix.showMenu(); // Chama o método na classe MenuMatrix

            if (result.equals("")) {
                JOptionPane.showMessageDialog(null, "Digite um valor numérico!");
            } else {
                input = Integer.parseInt(result);

                switch (input) {
                    case 1:
                        // Inserir valor
                        String item = JOptionPane.showInputDialog("Digite um número para inserir na árvore:");
                        try {
                            int value = Integer.parseInt(item);
                            tree.insert(value);
                            JOptionPane.showMessageDialog(null, "Número " + value + " inserido na árvore.");
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Valor inválido! Digite um número.");
                        }
                        break;
                    case 2:
                        // Remover valor
                        String removeItem = JOptionPane.showInputDialog("Digite um número para remover da árvore:");
                        try {
                            int value = Integer.parseInt(removeItem);
                            boolean removed = tree.remove(value);
                            if (removed) {
                                JOptionPane.showMessageDialog(null, "Número " + value + " removido da árvore.");
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Valor inválido! Digite um número.");
                        }
                        break;
                    case 3:
                        // Exibir árvore no console
                        System.out.println("Exibir Matriz:");
                        tree.printTree();
                        System.out.println();
                        break;
                    case 4:
                        // Exibir raiz
                        System.out.println("Exibir Raiz:");
                        tree.displayRoot();
                        System.out.println();
                        break;
                    case 5:
                        // Exibir Ordem Simétrica
                        System.out.println("Exibir Ordem Simetrica:");
                        tree.inorderTraversal(); // Chame sem argumento
                        System.out.println();
                        break;
                    case 6:
                        // Exibir Pré-Ordem
                        System.out.println("Exibir Pré-Ordem");
                        tree.preorderTraversal(); // Chame sem argumento
                        System.out.println();
                        break;
                    case 7:
                        // Exibir Pós-Ordem
                        System.out.println("Exibir Pós-Ordem");
                        tree.postorderTraversal(); // Chame sem argumento
                        System.out.println();
                        break;
                    case 0:
                        // Sair
                        JOptionPane.showMessageDialog(null, "Saindo do programa.");
                        System.out.println("Obrigado por utilizar nosso sistema!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida! Escolha novamente.");
                }
            }
        }
    }
}
