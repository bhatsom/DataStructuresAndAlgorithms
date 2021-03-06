package com.somnath.apps.algo.easy;

import java.util.HashSet;
import java.util.Set;

/**
 problem statement:
 ------------------
 Given a number 'x', and a range ‘y’ to ‘z’, find the count of all the numbers ‘n’ in that range, such that the product
 of the number ‘n’ and 'x' does not contain any digit from the number ‘n’.

 Constraints: All the inputs will be integers and below 10

 E.g., when x = 2, y = 10 and z = 15, then:
 2 x 10 = 20 // Invalid, since the product contains 0 from 10.
 2 x 11 = 22 // Valid
 2 x 12 = 24 // Invalid, since the product contains 2 from 12.
 2 x 13 = 26 // Valid
 2 x 14 = 28 // Valid
 2 x 15 = 30 // Valid
 Hence, the total count satisfying the criteria is 4.
 */
public class NonRepeatingDigitInProduct {

	public static void main(String[] args) {
		System.out.println("nonRepeatingDigitProductCount 1: " + nonRepeatingDigitProductCount(2, 10, 15));
		System.out.println("nonRepeatingDigitProductCount 2: " + nonRepeatingDigitProductCount(1, 10, 15));
	}

	public static int nonRepeatingDigitProductCount(int x, int y, int z) {
		Set<Character> set1 = new HashSet<>();
		Set<Character> set2 = new HashSet<>();

		if (y > z || x == 1)
			return 0;

		int countInValid = 0;
		for (int i = y; i <= z; i++) {
			long product = i * x;

			for (char ch : (i + "").toCharArray())
				set1.add(ch);

			for (char ch : (product + "").toCharArray())
				set2.add(ch);

			int set2Size = set2.size();
			set2.addAll(set1);
			if (set1.size() + set2Size > set2.size()) {
				countInValid++;
			}
			set1.clear();
			set2.clear();
		}
		return ((z - y) + 1) - countInValid;
	}

}