package br.com.unifacisa.binaryMatrix;

import javax.swing.JOptionPane;

public class MenuMatrix {
    // Método para exibir o menu ao usuário e retornar a escolha
    public static String showMenu() {
        // Menu com opções para o usuário interagir
        String result = JOptionPane.showInputDialog("" +
                "Digite:" +
                "\n 1: Inserir um valor" +
                "\n 2: Remover um valor" +
                "\n 3: Exibir Matriz" +
                "\n 4: Exibir a Raiz" +
                "\n 5: Exibir Ordem Simétrica (In-Order)" +
                "\n 6: Exibir Pré-Ordem (Pre-Order)" +
                "\n 7: Exibir Pós-Ordem (Post-Order)" +
                "\n 0: Para Sair");

        if (result == null) {
            result = "";
        }

        return result; // Retorna a escolha do usuário
    }
}