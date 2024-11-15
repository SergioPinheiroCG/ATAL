package br.com.unifacisa.binaryTrees;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int input = -1;
        BinaryMatrix tree = new BinaryMatrix(); // Inicializa a árvore binária

        while (input != 0) {
            String result = MenuMatrix.showMenu(); // Chama o método na classe MenuMatrix

            if (result.equals("")) {
                JOptionPane.showMessageDialog(null, "Digite um valor numérico!");
            } else {
                input = Integer.parseInt(result);

                switch (input) {
                    case 1:
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
                        JOptionPane.showMessageDialog(null, "A árvore será exibida no console!");
                        tree.printTree();
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Saindo do programa.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida! Escolha novamente.");
                }
            }
        }
    }
}
