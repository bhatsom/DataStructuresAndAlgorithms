package com.somnath.apps.ds.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

	Map<Character, Node> rootChars = new HashMap<>();

	private static class Node {
		Character c;
		Map<Character, Node> children;
		boolean isWord;

		Node(Character c){
			this.c = c;
			children = new HashMap<>();
		}

		@Override
		public String toString() {
			return "Node{" +
					"c=" + c +
					", children=" + children +
					", isWord=" + isWord +
					'}';
		}
	}

	// push - add a character to the Trie data structure
	public void push(String word) {
		// validate word for null, empty, whitespace only
		Character rootChar = word.charAt(0);
		rootChars.putIfAbsent(rootChar, new Node(rootChar));
		Character currChar;
		Node currNode = null;
		Node parent = rootChars.get(rootChar);

		for (int i=1; i<word.length(); i++) {
			currChar = word.charAt(i);
			Map<Character, Node> children = parent.children;

			System.out.println("Processing char: " + currChar);
			System.out.println("Parent is: " + parent);
			// IF char is not present in Trie path, add it
			if (!children.containsKey(currChar)) {
				currNode = new Node(currChar);
				children.put(currChar, currNode);
				System.out.println(currChar + "  is missing in the path. Added to Trie.");
			} else { // move on to the next char
				System.out.println(currChar + "  is present in the path. Move on to next char.");
			}

			// set isWord
			if (i == word.length() -1)
				currNode.isWord = true;

			parent = currNode;
			currNode.toString();
		}

	}

	// find - search for a word in the Trie data structure

	// delete - delete a word from the Trie data structure

	public static void main(String[] args) {

		Trie trie = new Trie();
		trie.push("car");

	}
}
