package br.com.unifacisa.binaryTrees;

import br.com.unifacisa.graph.Grafo;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		int input = 20;
		String result;

		Binary tree = new Binary(); // Binary Tree
		Grafo grafo = new Grafo(5); // Instancia o Grafo

		// Configura o grafo com arestas
		grafo.addEdge(0, 1);
		grafo.addEdge(0, 4);
		grafo.addEdge(1, 2);
		grafo.addEdge(1, 3);
		grafo.addEdge(1, 4);
		grafo.addEdge(2, 3);
		grafo.addEdge(3, 4);

		while (input != 0) {
			result = showMenu();

			if (result.equals("")) {
				JOptionPane.showMessageDialog(null, "Digite um valor numérico!");
				result = showMenu();
			} else {
				input = Integer.parseInt(result);

				switch (input) {
					case 1:
						String item = JOptionPane.showInputDialog("Digite um numero para inserir na árvore!");
						tree.insert(Integer.parseInt(item));
						break;
					case 2:
						String vl = JOptionPane.showInputDialog("Digite o valor que você deseja Remover!");
						tree.remove(Integer.parseInt(vl)); // Atualiza a árvore com a remoção
						break;

					case 3:
						JOptionPane.showMessageDialog(null, "Os valores serão exibidos no console!");
						tree.showRoot();
						System.out.println("");
						break;
					case 4:
						JOptionPane.showMessageDialog(null, "Os valores serão exibidos no console!");
						System.out.println("Ordem simétrica:");
						tree.inOrder(tree.getRoot());
						System.out.println("");
						break;
					case 5:
						JOptionPane.showMessageDialog(null, "Os valores serão exibidos no console!");
						System.out.println("Pré-ordem:");
						tree.preOrder(tree.getRoot());
						System.out.println("");
						break;
					case 6:
						JOptionPane.showMessageDialog(null, "Os valores serão exibidos no console!");
						System.out.println("Pós-ordem:");
						tree.postOrder(tree.getRoot());
						System.out.println("");
						break;

					case 7: // Implementação da BFS no Grafo
						String start = JOptionPane.showInputDialog("Digite o vértice inicial para a BFS no grafo:");

						// Valida se a entrada é nula ou vazia
						if (start == null || start.trim().isEmpty()) {
							JOptionPane.showMessageDialog(null,
									"Vértice inválido! Você deve inserir um número válido correspondente a um vértice.");
							break;
						}

						try {
							int startVertex = Integer.parseInt(start);

							// Verifica se o vértice está dentro do intervalo válido
							if (startVertex >= 0 && startVertex < grafo.getNumVertices()) {
								grafo.bfs(start); // Chama o método BFS no grafo com a entrada como String
							} else {
								JOptionPane.showMessageDialog(null,
										"Vértice inválido! Digite um valor numérico entre 0 e "
												+ (grafo.getNumVertices() - 1));
							}
						} catch (NumberFormatException e) {
							// Mensagem específica para entradas não numéricas
							JOptionPane.showMessageDialog(null,
									"Entrada inválida! Você deve inserir apenas números correspondentes aos vértices.");
						}
						break;
				}
			}
		}
	}

	public static String showMenu() {
		String result = JOptionPane.showInputDialog("" +
				"Digite:" +
				"\n 1: Para inserir " +
				"\n 2: para Remover" +
				"\n 3: Para Exibir a Raiz " +
				"\n 4: Para Exibir ordem simétrica " +
				"\n 5: Para Exibir pré-ordem " +
				"\n 6: Para Exibir pós-ordem " +
				"\n 7: Para Buscar em Largura (BFS)" + // Opção para buscar em largura
				"\n 0: Para Sair");

		if (result == null) {
			result = "";
		}

		return result;
	}
}
