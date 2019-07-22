package com.somnath.apps.ds.btree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://wwww.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
 * Tine Complexity : O(n)
 * Auxiliary Space : If we don't consider size of stack for function calls then O(1) otherwise O(n).
 */


class BinaryTreeBottomview {

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

		public void bottomView() {
			List<Integer> bottomNodes = new ArrayList<>();
			bottomViewUtil(root, bottomNodes);
			System.out.print("Bottom View: " + bottomNodes);
		}

		private void bottomViewUtil(Node node, List<Integer> bottomNodes) {
			if (node == null)
				return;
			if (node.left == null && node.right == null)
				bottomNodes.add(node.key);
			else {
				bottomViewUtil(node.left, bottomNodes);
				bottomViewUtil(node.right, bottomNodes);
			}
			System.out.println("Bottom Nodes: " + bottomNodes);
		}
	}

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.bottomView();
		System.out.println();

	}
}