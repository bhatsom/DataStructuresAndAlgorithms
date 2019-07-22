package com.somnath.apps.algo.easy;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	private static Map<Integer, Integer> computedFib = new HashMap<>();

	public static void main(String[] args) {

		System.out.println("0 1 1 2 3 5 8 13 21 34 55 89");

		if(countFibonacciNumbers(10,100) == 5){
			System.out.println("Passed");
			return;
		}
		System.out.println("Failed");
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

}
