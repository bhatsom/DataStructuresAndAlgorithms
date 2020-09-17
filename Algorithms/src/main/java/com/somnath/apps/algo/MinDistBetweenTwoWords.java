package com.somnath.apps.algo;

//https://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/

/**
 * Input: arr[] = {2, 5, 3, 5, 4, 4, 2, 3}, x = 3, y = 2
 * Output: Minimum distance between 3 and 2 is 1.
 * Explanation: 3 is at index 7 and 2 is at index 6, so the distance is 1
 */
public class MinDistBetweenTwoWords {

	public static void main (String[] args) {
		String[] words = {"a", "b", "c", "a", "d"};
		System.out.println("Min distance: " + getMinDistance(words, "a", "d"));
		System.out.println("Min distance: " + getMinDistance(words, "b", "d"));
	}

	private static int getMinDistance(String[] words, String str1, String str2) {
		int indx1 = -1;
		int indx2 = -1;
		int minDistance = Integer.MAX_VALUE;
		int tempDistance;

		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(str1)) {
				indx1 = i;
			}

			if (words[i].equals(str2)) {
				indx2 = i;
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
