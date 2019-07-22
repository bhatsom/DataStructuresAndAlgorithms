package com.somnath.apps.algo;

public class MinDistBetweenTwoWords {

	//https://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/

	public static void main (String[] args) {
		String[] words = {"a", "b", "c", "a", "d"};
		System.out.println("Min distance: " + getMinDistance(words, "a", "d"));
	}

	private static int getMinDistance(String[] words, String str1, String str2) {
		int indx1 = -1;
		int indx2 = -1;
		int minDistance = Integer.MAX_VALUE;
		int tempDistance;

		for (int x = 0; x < words.length; x++) {
			if (words[x].equals(str1)) {
				indx1 = x;
			}

			if (words[x].equals(str2)) {
				indx2 = x;
			}

			if (indx1 != -1 && indx2 != -1) { // both words have to be found
				tempDistance = Math.abs(indx2 - indx1);
				if (tempDistance < minDistance) {
					minDistance = tempDistance;
				}
			}
		}
		return minDistance;
	}

}
