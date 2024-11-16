package br.com.unifacisa.binaryTrees;

public class Node {

	private Node right;
	private Node left;
	private int value;

	// Inicializa o nó com um valor e filhos nulos
	public Node(int value) {
		this.value = value;
		this.right = null;
		this.left = null;
	}

	// Inicializa o nó com valor e filhos especificados
	public Node(Node left, int value, Node right) {
		this.value = value;
		this.right = right;
		this.left = left;
	}

	// Método para limpar o nó (definir o valor como 0 e os filhos como nulos)
	public void clear() {
		this.value = 0;
		this.right = null;
		this.left = null;
	}

	public int getValue() {
		return this.value;
	}

	public Node getLeft() {
		return this.left;
	}

	public Node getRight() {
		return this.right;
	}

	// Método para definir o valor do nó
	public void setValue(int value) {
		this.value = value;
	}

	// Métodos para configurar os filhos
	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}
