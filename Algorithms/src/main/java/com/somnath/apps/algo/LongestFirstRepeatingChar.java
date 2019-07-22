package com.somnath.apps.algo;

public class LongestFirstRepeatingChar {

	public static void main(String[] args) {
		printLongestFirstRepeating("aaakkbdcccccczz");
		printLongestFirstRepeating("aaakkbdcccczzzzz");
	}

	public static void printLongestFirstRepeating(String str) {
		char[] chars = str.toCharArray();
		int tmpCount = 1, longestCount = 1;
		int tmpIndex = -1, longestIndex = -1;
		boolean indxSet = false;

		for (int i = 1;  i < chars.length; i++) {
			if (chars[i] == chars[i - 1]) {
				tmpCount++;
				if(!indxSet) {
					tmpIndex = i-1;
					indxSet = true;
				}
			} else {
				if (tmpCount > longestCount) {
					longestCount = tmpCount;
					longestIndex = tmpIndex;
				}
				indxSet = false;
				tmpCount = 1;
			}
		}
		if (tmpCount > longestCount) {
			longestCount = tmpCount;
			longestIndex = tmpIndex;
		}

		System.out.printf("Longest repeating char index: %d count: %d \n", longestIndex, longestCount);
	}

}
