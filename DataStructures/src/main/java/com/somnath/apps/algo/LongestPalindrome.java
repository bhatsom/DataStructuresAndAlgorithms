package com.somnath.apps.algo;

public class LongestPalindrome {
	//https://www.journaldev.com/530/longest-palindrome-string-java
	//https://stackoverflow.com/questions/1115001/write-a-function-that-returns-the-longest-palindrome-in-a-given-string


	public static String getLongestPalindrome1(final String input) {
		int rightIndex, leftIndex;
		String currentPalindrome, longestPalindrome = "";

		for (int centerIndex = 1; centerIndex < input.length() - 1; centerIndex++) {
			leftIndex = centerIndex - 1;
			rightIndex = centerIndex + 1;

			while (leftIndex >= 0 && rightIndex < input.length()) {
				if (input.charAt(leftIndex) != input.charAt(rightIndex)) {
					break;
				}
				currentPalindrome = input.substring(leftIndex, rightIndex + 1);
				longestPalindrome = currentPalindrome.length() > longestPalindrome.length() ? currentPalindrome : longestPalindrome;
				leftIndex--;
				rightIndex++;
			}
		}
		return longestPalindrome;
	}

	private static String intermediatePalindrome(String s, int left, int right) {
		if (left > right)
			return null;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}

	/**
	 * @param s is the String input
	 * @return The longest palindrome found in the given input
	 */
	// O(n^2)
	public static String getLongestPalindrome(String s) {
		if (s == null || s.isEmpty())
			return null;

		String longest = s.substring(0, 1);
		for (int i = 1; i < s.length() - 1; i++) { //start at 1 or 0?
			//odd cases like 121
			String palindrome = intermediatePalindrome(s, i, i);
			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
			//even cases like 1221
			palindrome = intermediatePalindrome(s, i, i + 1);
			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
		}
		return longest;
	}

	public static void main(String ... args) {
		//String str = "HYTBCABADEFGHABCDEDCBAGHTFYW12345678987654321ZWETYGDE";
		String str = "H";
		//String str = "HY";
		//String str = "HYT";
		//String str = "HYTB";
		String longestPali = getLongestPalindrome(str);
		System.out.println("String: " + str);
		System.out.println("Longest Palindrome: " + longestPali);
	}

}
