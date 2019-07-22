package com.somnath.apps;

import com.somnath.apps.ds.btree.BinarySearchTree;

public class MyTestApp {

	public static void main(String[] args) {
		int[] data = new int[5];
		data[0] = 1;
		data[1] = 3;
		data[2] = 5;

		System.out.println("data length/capacity:" + data.length);
		System.out.println("data:" + data.toString()); // hashCode pointing to memory address

		BinarySearchTree bst = new BinarySearchTree();

	}
}
