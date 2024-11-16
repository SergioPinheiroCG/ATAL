package br.com.unifacisa.binaryTrees;

public class Binary {

	private Node root;

	// Representação do nó da árvore
	private static class Node {
		int value;
		Node left, right;

		public Node(int item) {
			value = item;
			left = right = null;
		}
	}

	public Binary() {
		root = null;
	}

	// Inserção na árvore binária
	public void insert(int value) {
		root = insertRecursive(root, value);
	}

	private Node insertRecursive(Node root, int value) {
		if (root == null) {
			root = new Node(value);
			return root;
		}

		if (value < root.value) {
			root.left = insertRecursive(root.left, value);
		} else if (value > root.value) {
			root.right = insertRecursive(root.right, value);
		}

		return root;
	}

	// Exibe a raiz da árvore
	public void showRoot() {
		if (root != null) {
			System.out.println("Raiz: " + root.value);
		} else {
			System.out.println("A árvore está vazia.");
		}
	}

	// Ordem Simétrica (In-order)
	public void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.value + " ");
			inOrder(root.right);
		}
	}

	// Pré-Ordem (Pre-order)
	public void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.value + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	// Pós-Ordem (Post-order)
	public void postOrder(Node root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.value + " ");
		}
	}

	// Remove um valor da árvore
	public void remove(int value) {
		root = removeRecursive(root, value);
	}

	private Node removeRecursive(Node root, int value) {
		if (root == null) {
			return null;
		}

		if (value < root.value) {
			root.left = removeRecursive(root.left, value);
		} else if (value > root.value) {
			root.right = removeRecursive(root.right, value);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}

			root.value = findMin(root.right);
			root.right = removeRecursive(root.right, root.value);
		}

		return root;
	}

	private int findMin(Node root) {
		return root.left == null ? root.value : findMin(root.left);
	}

	// Método para obter a raiz da árvore
	public Node getRoot() {
		return root;
	}
}
