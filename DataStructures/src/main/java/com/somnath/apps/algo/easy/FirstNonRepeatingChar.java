package com.somnath.apps.algo.easy;

import java.util.*;

public class FirstNonRepeatingChar {

	public static void main (String[] args) {

		System.out.println("1: " + firstNonRepeatingChar("abcdefghija"));
		System.out.println("2: " + firstNonRepeatingChar2("abcdefghija"));

		System.out.println("1: " + firstNonRepeatingChar("hello"));
		System.out.println("2: " + firstNonRepeatingChar2("hello"));
	}

	/*
	* Finds first non repeated character in a String in just one pass. It uses two storage to cut down one iteration,
	* standard space vs time trade-off. Since we store repeated and non-repeated character separately,
	* at the end of iteration, first element from List is our first non-repeated character from String.
	*/
	// single iteration approach - O(n) - more space
	public static char firstNonRepeatingChar(String word) {
		Set<Character> repeating = new HashSet<>();
		List<Character> nonRepeating = new ArrayList<>();

		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			System.out.println("processing: " + letter);
			if (repeating.contains(letter)) {
				continue;
			}

			if (nonRepeating.contains(letter)) {
				nonRepeating.remove((Character) letter);
				repeating.add(letter);
			} else {
				nonRepeating.add(letter);
			}
		}
		return nonRepeating.get(0);
	}

	// two iteration - O(n) - less space
	public static char firstNonRepeatingChar2(String str) {
		Map<Character, Integer> counts = new LinkedHashMap<>(str.length());

		for (char c : str.toCharArray()) {
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
		}

		for (Map.Entry<Character,Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}

		throw new RuntimeException("didn't find any non repeated Character");
	}

}
