package com.somnath.apps.algo;

import java.util.Arrays;
import java.util.Comparator;

public class AnagramsTogether {
	//https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/

	// class for each word of duplicate array
	static class Word
	{
		String word;  // to store word itself
		int index; // index of the word in the original array

		Word(String word, int index)	{
			this.word = word;
			this.index = index;
		}
	}

	// Compare two words. Used in Arrays.sort() for sorting an array of words
	static class WordSorter implements Comparator<Word>
	{
		public int compare(Word a, Word b)
		{
			return a.word.compareTo(b.word);
		}
	}

	// Given a list of words in wordArr[]
	static void printAnagramsTogether(String wordArr[]) {

		int words = wordArr.length;

		//Step 1: Create a copy of all words present in wordArr. The copy will also have original indexes of words
		Word[] dupArray = new Word[words];
		for (int i = 0; i < words; ++i) {
			dupArray[i] = new Word(wordArr[i], i);
		}

		// Step 2: Iterate through all words in dupArray and sort individual words.
		for (int i = 0; i < words; i++) {
			char[] chars  = dupArray[i].word.toCharArray();
			Arrays.sort(chars);
			dupArray[i].word = new String(chars);
		}

		// Step 3: Now sort the array of words in dupArray
		Arrays.sort(dupArray, new WordSorter());

		// Step 4: Now all words in dupArray are together, but these words are changed.
		// Use the index member of word struct to get the corresponding original word
		for (int i = 0; i < words; i++)
			System.out.print(wordArr[dupArray[i].index] + " ");
	}

	public static void main(String args[]) {
		String wordArr[] = {"cat", "dog", "tac", "god", "act"};
		printAnagramsTogether(wordArr);
	}

}
