package br.com.unifacisa.binaryTrees;

public class BinaryMatrix {
    private int[][] tree; // Matriz 2D para armazenar a árvore
    private int rootIndex = -1; // Índice da raiz, inicialmente indefinido

    public BinaryMatrix() {
        tree = new int[5][3]; // Inicializa com 5 nós
        initializeTree();
    }

    // Inicializa a matriz com valores padrão
    private void initializeTree() {
        for (int i = 0; i < tree.length; i++) {
            tree[i][0] = Integer.MIN_VALUE; // Valor padrão para nós vazios
            tree[i][1] = -1; // Filho esquerdo
            tree[i][2] = -1; // Filho direito
        }
    }

    // Método para inserir valor na árvore
    public void insert(int value) {
        if (rootIndex == -1) {
            // Se a árvore estiver vazia, o primeiro nó será a raiz
            tree[0][0] = value;
            rootIndex = 0;
        } else {
            // Insere o valor iterativamente
            int currentIndex = rootIndex;

            while (true) {
                if (value < tree[currentIndex][0]) {
                    // Vai para o filho esquerdo
                    if (tree[currentIndex][1] == -1) {
                        int newIndex = allocateNode(value);
                        tree[currentIndex][1] = newIndex;
                        break;
                    } else {
                        currentIndex = tree[currentIndex][1];
                    }
                } else if (value > tree[currentIndex][0]) {
                    // Vai para o filho direito
                    if (tree[currentIndex][2] == -1) {
                        int newIndex = allocateNode(value);
                        tree[currentIndex][2] = newIndex;
                        break;
                    } else {
                        currentIndex = tree[currentIndex][2];
                    }
                } else {
                    // Valor já existe na árvore, não insere duplicados
                    System.out.println("Valor " + value + " já existe na árvore.");
                    break;
                }
            }
        }
    }

    // Aloca um novo nó na matriz, expandindo se necessário
    private int allocateNode(int value) {
        // Verifica se a matriz precisa ser expandida
        for (int i = 0; i < tree.length; i++) {
            if (tree[i][0] == Integer.MIN_VALUE) {
                tree[i][0] = value;
                return i;
            }
        }

        // Expande a matriz se não houver espaço
        expandTree();
        return allocateNode(value);
    }

    // Método para expandir a matriz
    private void expandTree() {
        int newSize = tree.length + 5; // Aumenta a matriz em 5 posições
        int[][] newTree = new int[newSize][3];

        // Copia os valores antigos para a nova matriz
        for (int i = 0; i < tree.length; i++) {
            newTree[i][0] = tree[i][0];
            newTree[i][1] = tree[i][1];
            newTree[i][2] = tree[i][2];
        }

        // Inicializa os novos nós
        for (int i = tree.length; i < newSize; i++) {
            newTree[i][0] = Integer.MIN_VALUE;
            newTree[i][1] = -1;
            newTree[i][2] = -1;
        }

        tree = newTree;
    }

    // Método para exibir a árvore
    public void printTree() {
        System.out.println("Índice | Valor | Filho Esquerdo | Filho Direito");
        System.out.println("-----------------------------------------------");

        for (int i = 0; i < tree.length; i++) {
            if (tree[i][0] != Integer.MIN_VALUE) { // Não exibe nós vazios
                System.out.printf("   %d   |  %d   |       %d       |       %d\n", i, tree[i][0], tree[i][1],
                        tree[i][2]);
            }
        }
    }
}
