package com.somnath.apps.algo.bst;

// check if given Binary tree is a BST or not
//https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/

public class IfBinaryTree {
	//Root of the Binary Tree 
	Node root; 

	/* can give min and max value according to your code or 
	can write a function to find min and max value of tree. */

	/* returns true if given search tree is binary search tree (efficient version) */
	boolean isBST() { 
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	} 

	/* Returns true if the given tree is a BST and its 
	values are >= min and <= max. */
	boolean isBSTUtil(Node node, int min, int max) {
		/* an empty tree is BST */
		if (node == null) 
			return true; 

		/* false if this node violates the min/max constraints */
		if (node.data < min || node.data > max) 
			return false; 

		/* otherwise check the subtrees recursively tightening the min/max constraints */
		// Allow only distinct values 
		return (
			isBSTUtil(node.left, min, node.data-1) &&
			isBSTUtil(node.right, node.data+1, max)
		);
	} 

	/* Driver program to test above functions */
	public static void main(String args[]) {
		IfBinaryTree tree = new IfBinaryTree();

		tree.root = new Node(4); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(5); 
		tree.root.left.left = new Node(1); 
		tree.root.left.right = new Node(3); 

		if (tree.isBST()) 
			System.out.println("IS BST"); 
		else
			System.out.println("Not a BST"); 
	}

	/*
	Class containing left and right child of current node and key value
	*/
	private static class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

} 
