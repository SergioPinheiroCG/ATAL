package br.com.unifacisa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Grafo {

    private int numVertices;
    private List<List<Integer>> adjacencyList;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new ArrayList<>(numVertices);

        for (int i = 0; i < numVertices; i++) {
            this.adjacencyList.add(new LinkedList<>());
        }
    }

    public void addEdge(int v, int w) {
        adjacencyList.get(v).add(w);
        adjacencyList.get(w).add(v); // Como é um grafo não direcionado, adicionamos a ligação inversa também
    }

    // Método para obter o número de vértices
    public int getNumVertices() {
        return numVertices;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            sb.append("Vértice: ").append(i).append(":\n");
            for (Integer neighbor : adjacencyList.get(i)) {
                sb.append(" -> ").append(neighbor).append("\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void bfs(String startVertexInput) {
        // Verifica se a entrada é nula ou vazia
        if (startVertexInput == null || startVertexInput.trim().isEmpty()) {
            System.out.println("Vértice inválido! Você deve inserir um número.");
            return;
        }

        try {
            // Tenta converter a entrada para um número inteiro
            int startVertex = Integer.parseInt(startVertexInput);

            // Verifica se o vértice de início é válido
            if (startVertex < 0 || startVertex >= numVertices) {
                System.out.println("Vértice inválido! O valor deve estar entre 0 e " + (numVertices - 1));
                return;
            }

            // Inicializa a BFS
            boolean[] visited = new boolean[this.numVertices];
            LinkedList<Integer> queue = new LinkedList<>();

            visited[startVertex] = true;
            queue.add(startVertex);

            System.out.println("Busca em Largura (BFS) a partir do vértice " + startVertex + ":");

            while (!queue.isEmpty()) {
                int vertex = queue.poll();
                System.out.print(vertex + " ");

                // Adiciona os vizinhos do vértice atual à fila, se ainda não foram visitados
                for (int neighbor : adjacencyList.get(vertex)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
            System.out.println(); // Quebra de linha para a saída
        } catch (NumberFormatException e) {
            System.out.println("Vértice inválido! Você deve inserir um número.");
        }
    }
}
