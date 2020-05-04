package com.somnath.apps.algo.easy;

public class Factorial {

	public static void main(String[] args) {

		System.out.println("Factorial recursive: " + factorialRecursive(5));
		System.out.println("Factorial iterative: " + factorialIterative(5));

	}

	/**
	 * https://stackoverflow.com/questions/2327244/complexity-of-recursive-factorial-program
	 *
	 * Factorial(n) is directly proportional to n. Therefore, the time complexity of recursive factorial is O(n).
	 * As there is no extra space taken during the recursive calls, the space complexity is also O(n).
	 *
	 * @param n
	 * @return
	 */

	public static int factorialRecursive(int n)	{
		if (n <= 1)
			return 1;
		return n * factorialRecursive(n - 1);
	}

	//iterative function calculates n!
	// Time-Complexity = O(N) and Space-Complexity = O(N)
	public static int factorialIterative(int n) {
		int fact = 1;

		if (n <= 1)
			return fact;

		while (n > 1) {
			fact *= n;
			n--;
		}
		return fact;
	}

}
