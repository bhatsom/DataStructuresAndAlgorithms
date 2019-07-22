package com.somnath.apps.ds.btree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSerialize {

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

		public Queue<Integer> serialize() {
			// validations
			// Root = NULL - empty Binary Tree
			if (root == null)
				return null;

			// do pre-order traversal and store the node vals in a Queue
			Queue<Integer> queue = new LinkedList<>();
			serializeUtil(root, queue);
			return queue;
		}

		private void serializeUtil(Node node, Queue<Integer> queue) {
			if (node == null) {
				queue.add(-1);
				return;
			}

			queue.add(node.key);
			serializeUtil(node.left, queue);
			serializeUtil(node.right, queue);
		}

		public void deSerialize(Queue<Integer> queue) {
			Integer val = queue.peek();

			if (val == null || val.intValue() == -1)
				return;
			deSerializeUtil(root, queue);
		}

		private void deSerializeUtil(Node node, Queue<Integer> queue) {
			Integer val = queue.poll();

			if (val == null || val.intValue() == -1)
				return;

			node = new Node(val);
			deSerializeUtil(node.left, queue);
			deSerializeUtil(node.right, queue);
		}

		private void printInorder(Node node) {
			if (node == null)
				return;

			//recur on left subtree
			printInorder(node.left);
			// deal with the node
			System.out.print(node.key + " ");
			// recur on right subtree
			printInorder(node.right);
		}

	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);

		System.out.print("In-order traversal before serialization: ");
		bt.printInorder(bt.root);
		System.out.println();

		Queue<Integer> serialized = bt.serialize();
		System.out.println("Serialized: " + serialized);

		System.out. println("De-serializing..");
		bt.deSerialize(serialized);
		System.out. println("De-serialization DONE..");

		System.out.println("In-order traversal after de-serialization: ");
		bt.printInorder(bt.root);

	}
}
