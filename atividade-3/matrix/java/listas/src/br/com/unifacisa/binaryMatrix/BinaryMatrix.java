package br.com.unifacisa.binaryMatrix;

import java.util.Stack;

public class BinaryMatrix {

    private int[][] tree; // A árvore binária será representada por uma matriz 2D
    private int rootIndex; // Índice da raiz

    public BinaryMatrix(int size) {
        tree = new int[size][3]; // A matriz terá 3 colunas: [valor, índice filho esquerdo, índice filho direito]
        rootIndex = -1; // Inicializa a raiz como inexistente
        for (int i = 0; i < size; i++) {
            tree[i][0] = Integer.MIN_VALUE; // Valor inicial vazio
            tree[i][1] = -1; // Índice do filho esquerdo
            tree[i][2] = -1; // Índice do filho direito
        }
    }

    // Método para inserir um valor na árvore
    public void insert(int value) {
        if (rootIndex == -1) {
            rootIndex = 0;
            tree[0][0] = value;
            return;
        }

        int currentIndex = rootIndex;
        while (true) {
            if (value < tree[currentIndex][0]) { // Vai para a esquerda
                if (tree[currentIndex][1] == -1) {
                    tree[currentIndex][1] = findEmptyNode();
                    tree[tree[currentIndex][1]][0] = value;
                    break;
                } else {
                    currentIndex = tree[currentIndex][1];
                }
            } else { // Vai para a direita
                if (tree[currentIndex][2] == -1) {
                    tree[currentIndex][2] = findEmptyNode();
                    tree[tree[currentIndex][2]][0] = value;
                    break;
                } else {
                    currentIndex = tree[currentIndex][2];
                }
            }
        }
    }

    // Método para encontrar um nó vazio na árvore
    private int findEmptyNode() {
        for (int i = 0; i < tree.length; i++) {
            if (tree[i][0] == Integer.MIN_VALUE) {
                return i;
            }
        }
        return -1; // Não há espaço para um novo nó
    }

    // Método para remover um nó da árvore
    public boolean remove(int value) {
        int index = findNode(value);
        if (index == -1) {
            System.out.println("Valor não encontrado na árvore.");
            return false;
        }

        // Se o nó for folha (não tem filhos)
        if (tree[index][1] == -1 && tree[index][2] == -1) {
            tree[index][0] = Integer.MIN_VALUE;
            return true;
        }

        // Para nó com um filho (esquerdo ou direito)
        if (tree[index][1] == -1 || tree[index][2] == -1) {
            int childIndex = (tree[index][1] != -1) ? tree[index][1] : tree[index][2];
            tree[index][0] = tree[childIndex][0];
            tree[index][1] = tree[childIndex][1];
            tree[index][2] = tree[childIndex][2];
            tree[childIndex][0] = Integer.MIN_VALUE; // Marca o nó filho como vazio
            return true;
        }

        // Para nó com dois filhos, procuramos o menor valor à direita
        int successorIndex = findMinNodeIndex(tree[index][2]);
        tree[index][0] = tree[successorIndex][0]; // Copia o valor do sucessor

        // Remover o nó sucessor
        int successorParentIndex = findParentNode(successorIndex);
        if (tree[successorParentIndex][1] == successorIndex) {
            tree[successorParentIndex][1] = -1; // Se o sucessor for o filho esquerdo
        } else {
            tree[successorParentIndex][2] = -1; // Se o sucessor for o filho direito
        }

        tree[successorIndex][0] = Integer.MIN_VALUE; // Marca o nó sucessor como vazio
        return true;
    }

    // Encontra o índice de um nó com valor específico
    private int findNode(int value) {
        for (int i = 0; i < tree.length; i++) {
            if (tree[i][0] == value) {
                return i;
            }
        }
        return -1; // Não encontrado
    }

    // Encontra o nó com o menor valor a partir de um índice
    private int findMinNodeIndex(int index) {
        while (tree[index][1] != -1) {
            index = tree[index][1]; // Vai para o filho esquerdo
        }
        return index;
    }

    // Encontra o nó pai de um nó dado
    private int findParentNode(int index) {
        for (int i = 0; i < tree.length; i++) {
            if (tree[i][1] == index || tree[i][2] == index) {
                return i;
            }
        }
        return -1; // Não encontrado
    }

    // Exibir a raiz da árvore
    public void displayRoot() {
        if (rootIndex != -1) {
            System.out.println("Raiz da Árvore: " + tree[rootIndex][0]);
        } else {
            System.out.println("A árvore está vazia.");
        }
    }

    // Método para exibir a árvore
    public void printTree() {
        System.out.println("Índice | Valor | Filho Esquerdo | Filho Direito");
        System.out.println("-----------------------------------------------");

        for (int i = 0; i < tree.length; i++) {
            if (tree[i][0] != Integer.MIN_VALUE) { // Não exibe nós vazios
                int leftChild = tree[i][1] == -1 ? -1 : tree[i][1];
                int rightChild = tree[i][2] == -1 ? -1 : tree[i][2];
                System.out.printf("   %d   |  %d   |       %d       |       %d\n", i, tree[i][0], leftChild,
                        rightChild);
            }
        }
    }

    // Exibir em Ordem Simétrica (In-Order) de forma iterativa
    public void inorderTraversal() {
        if (rootIndex == -1)
            return;

        // Utilizando uma pilha para simular a recursividade
        int currentIndex = rootIndex;
        Stack<Integer> stack = new Stack<>();

        while (currentIndex != -1 || !stack.isEmpty()) {
            while (currentIndex != -1) {
                stack.push(currentIndex);
                currentIndex = tree[currentIndex][1]; // Vai para o filho esquerdo
            }
            currentIndex = stack.pop();
            System.out.print(tree[currentIndex][0] + " "); // Exibe o valor do nó
            currentIndex = tree[currentIndex][2]; // Vai para o filho direito
        }
    }

    // Exibir em Pré-Ordem (Pre-Order) de forma iterativa
    public void preorderTraversal() {
        if (rootIndex == -1)
            return;

        // Utilizando uma pilha para simular a recursividade
        Stack<Integer> stack = new Stack<>();
        stack.push(rootIndex);

        while (!stack.isEmpty()) {
            int currentIndex = stack.pop();
            System.out.print(tree[currentIndex][0] + " "); // Exibe o valor do nó

            // Empilha os filhos (direita primeiro para que a esquerda seja processada
            // primeiro)
            if (tree[currentIndex][2] != -1) {
                stack.push(tree[currentIndex][2]);
            }
            if (tree[currentIndex][1] != -1) {
                stack.push(tree[currentIndex][1]);
            }
        }
    }

    // Exibir em Pós-Ordem (Post-Order) de forma iterativa
    public void postorderTraversal() {
        if (rootIndex == -1)
            return;

        // Utilizando duas pilhas para simular a recursividade
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        stack1.push(rootIndex);

        while (!stack1.isEmpty()) {
            int currentIndex = stack1.pop();
            stack2.push(currentIndex);

            // Empilha os filhos (esquerda primeiro)
            if (tree[currentIndex][1] != -1) {
                stack1.push(tree[currentIndex][1]);
            }
            if (tree[currentIndex][2] != -1) {
                stack1.push(tree[currentIndex][2]);
            }
        }

        // Imprime os nós da stack2
        while (!stack2.isEmpty()) {
            int currentIndex = stack2.pop();
            System.out.print(tree[currentIndex][0] + " ");
        }
    }
}
