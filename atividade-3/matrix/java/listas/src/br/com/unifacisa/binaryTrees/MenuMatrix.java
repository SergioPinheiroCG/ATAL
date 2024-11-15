package br.com.unifacisa.binaryTrees;

import javax.swing.JOptionPane;

public class MenuMatrix {
    // Método para exibir o menu ao usuário e retornar a escolha
    public static String showMenu() {
        String result = JOptionPane.showInputDialog("" +
                "Digite:" +
                "\n 1: Para Inserir um valor na árvore" +
                "\n 2: Para Exibir a Árvore no console" +
                "\n 0: Para Sair");

        if (result == null) {
            result = ""; // Se o usuário cancelar, retorna uma string vazia
        }
        return result;
    }
}
