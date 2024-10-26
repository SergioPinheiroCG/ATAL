package br.edu.unifacisa.listaencadeada;

public class ListaEncadeada<Elemento> {

    // Classe interna para representar um nodo da lista
    private class Nodo {
        Elemento dado;      // Valor do nodo (dado do tipo Elemento)
        Nodo proximo;       // Referência para o próximo nodo

        // Construtor do nodo
        Nodo(Elemento dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    // Atributos da lista encadeada
    private Nodo cabeca;   // Referência para o primeiro nodo (início da lista)
    private int tamanho;   // Tamanho atual da lista

    // Construtor da lista (inicialmente vazia)
    public ListaEncadeada() {
        this.cabeca = null;  // Nenhum elemento na lista
        this.tamanho = 0;    // Tamanho inicial é 0
    }

    // Adiciona um elemento no final da lista
    public void add(Elemento elemento) {
        Nodo novoNodo = new Nodo(elemento);  // Cria um novo nodo
        if (cabeca == null) {  // Se a lista está vazia
            cabeca = novoNodo;  // O novo nodo se torna a cabeça
        } else {
            Nodo atual = cabeca;  // Percorre a lista até o final
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNodo;  // Adiciona o novo nodo no final
        }
        tamanho++;  // Aumenta o tamanho da lista
    }

    // Adiciona um elemento em uma posição específica
    public void add(int index, Elemento elemento) {
        if (index < 0 || index > tamanho) {  // Verifica se o índice é válido
            throw new IndexOutOfBoundsException("Índice fora do limite");
        }

        Nodo novoNodo = new Nodo(elemento);  // Cria o novo nodo

        if (index == 0) {  // Se o índice for 0, insere no início
            novoNodo.proximo = cabeca;
            cabeca = novoNodo;
        } else {
            Nodo atual = cabeca;
            for (int i = 0; i < index - 1; i++) {  // Percorre até o índice anterior
                atual = atual.proximo;
            }
            novoNodo.proximo = atual.proximo;  // Ajusta as referências
            atual.proximo = novoNodo;
        }
        tamanho++;  // Incrementa o tamanho
    }

    // Remove o elemento por índice
    public Elemento remove(int index) {
        if (index < 0 || index >= tamanho) {  // Verifica se o índice é válido
            throw new IndexOutOfBoundsException("Índice fora do limite");
        }

        Nodo removido;
        if (index == 0) {  // Se for o primeiro elemento
            removido = cabeca;  // Remove a cabeça
            cabeca = cabeca.proximo;
        } else {
            Nodo atual = cabeca;
            for (int i = 0; i < index - 1; i++) {  // Percorre até o elemento anterior
                atual = atual.proximo;
            }
            removido = atual.proximo;  // Remove o nodo
            atual.proximo = removido.proximo;  // Ajusta a referência
        }
        tamanho--;  // Decrementa o tamanho
        return removido.dado;  // Retorna o valor removido
    }

    // Obtém o elemento por índice
    public Elemento get(int index) {
        if (index < 0 || index >= tamanho) {  // Verifica se o índice é válido
            throw new IndexOutOfBoundsException("Índice fora do limite");
        }

        Nodo atual = cabeca;
        for (int i = 0; i < index; i++) {  // Percorre até o índice desejado
            atual = atual.proximo;
        }
        return atual.dado;  // Retorna o valor do nodo
    }

    // Define um novo valor em uma posição específica
    public void set(int index, Elemento elemento) {
        if (index < 0 || index >= tamanho) {  // Verifica se o índice é válido
            throw new IndexOutOfBoundsException("Índice fora do limite");
        }

        Nodo atual = cabeca;
        for (int i = 0; i < index; i++) {  // Percorre até o índice desejado
            atual = atual.proximo;
        }
        atual.dado = elemento;  // Atualiza o valor
    }

    // Retorna o tamanho da lista
    public int size() {
        return tamanho;
    }

    // Verifica se a lista está vazia
    public boolean isEmpty() {
        return tamanho == 0;
    }

    // Verifica se a lista contém um elemento
    public boolean contains(Elemento elemento) {
        return indexOf(elemento) != -1;
    }

    // Retorna o índice da primeira ocorrência do elemento
    public int indexOf(Elemento elemento) {
        Nodo atual = cabeca;
        for (int i = 0; i < tamanho; i++) {
            if (atual.dado.equals(elemento)) {  // Compara os elementos
                return i;  // Retorna o índice da primeira ocorrência
            }
            atual = atual.proximo;
        }
        return -1;  // Retorna -1 se não for encontrado
    }

    // Retorna o índice da última ocorrência do elemento
    public int lastIndexOf(Elemento elemento) {
        int ultimoIndice = -1;
        Nodo atual = cabeca;
        for (int i = 0; i < tamanho; i++) {
            if (atual.dado.equals(elemento)) {
                ultimoIndice = i;  // Atualiza o último índice encontrado
            }
            atual = atual.proximo;
        }
        return ultimoIndice;
    }
}
