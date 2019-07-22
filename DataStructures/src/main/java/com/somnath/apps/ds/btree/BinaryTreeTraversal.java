package com.somnath.apps.ds.btree;

public class BinaryTreeTraversal {

	private static class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	private static class BinaryTree {
		Node root;

		public void printPostorder(Node node) {
			if (node == null)
				return;
			// recur on left subtnee
			printPostorder(node.left);
			// recur on right subtree
			printPostorder(node.right);
			// deal with the node
			System.out.print(node.key + " ");
		}

		public void printInorder(Node node) {
			if (node == null)
				return;

			//recur on left subtree
			printInorder(node.left);
			// deal with the node
			System.out.print(node.key + " ");
			// recur on right subtree
			printInorder(node.right);
		}

		public void printPreorder(Node node) {
			if (node == null)
				return;
			// deal with the node
			System.out.print(node.key + " ");
			// recur on left subtree
			printPreorder(node.left);
			// recur on right subtree
			printPreorder(node.right);
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);


		System.out.print("Pre-order: ");
		bt.printPreorder(bt.root);
		System.out.println();

		System.out.print("In-order: ");
		bt.printInorder(bt.root);
		System.out.println();

		System.out.print("Post-order:");
		bt.printPostorder(bt.root);
	}

}
