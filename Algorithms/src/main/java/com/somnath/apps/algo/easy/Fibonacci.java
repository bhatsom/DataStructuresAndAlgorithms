package com.somnath.apps.algo.easy;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	private static Map<Integer, Integer> computedFib = new HashMap<>();

	public static void main(String[] args) {

		System.out.println("0 1 1 2 3 5 8 13 21 34 55 89");

		/*if(countFibonacciNumbers(10,100) == 5){
			System.out.println("Passed");
			return;
		}
		System.out.println("Failed");
		*/

		computedFib.clear();
		long startTime = System.currentTimeMillis();
		System.out.println("START No Memoization: " + startTime);
		int res1 = 0;
		//int res1 = fibRecursive(100);
		System.out.println("DONE Time Taken: " + (System.currentTimeMillis() - startTime));
		System.out.println("Result: " + res1);

		startTime = System.currentTimeMillis();
		System.out.println("START with Memoization: " + startTime);
		int res2 = fibonacciRecursive(100);
		System.out.println("DONE Time Taken: " + (System.currentTimeMillis() - startTime));
		System.out.println("Result: " + res2);
	}

	private static int countFibonacciNumbers(int low, int high){
		int fib, count=0;
		if (high <= low) {
			System.out.println("Invalid range.");
			return count;
		}

		for (int i=0;; i++) {
			fib = fibonacciRecursive(i);
			System.out.println("Fibonacci # for index: " + i + " = " + fib);
			if (fib >= low && fib <= high)
				count++;
			if (fib > high)
				break;
		}
		System.out.println("Computed Fibonacci Numbers: " + computedFib);
		return count;

	}

	private static int fibonacciRecursive(int n) {
		//System.out.println("Calculating Fibonacci # for index: " + n);
		int fib;

		if (n <= 1)
			return n;

		if (computedFib.containsKey(n))
			return computedFib.get(n);
		else {
			fib = fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
			computedFib.put(n, fib);
			return fib;
		}
	}

	private static int fibonacciIterative(int n) {
		int prevPrev = 0;
		int prev = 1;
		int result = 0;

		if (n <= 1)
			return n;

		for (int i = 2; i <= n; i++) {
			result = prev + prevPrev;
			prevPrev = prev;
			prev = result;
		}
		return result;
	}

	private static int fibRecursive(int n){
		int res;

		if (n <=1)
			return 1;
//		if(computedFib.containsKey(n))
//			return computedFib.get(n);
//		else {
			res = fibRecursive(n-1) + fibRecursive(n-2);
			//computedFib.put(n, res);
		//}

		return res;
	}

}
