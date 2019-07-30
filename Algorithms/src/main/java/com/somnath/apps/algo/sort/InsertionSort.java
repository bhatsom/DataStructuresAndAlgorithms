package com.somnath.apps.sort;

public class InsertionSort {

	public static void main(String[] args) {

		//  https://en.wikipedia.org/wiki/Insertion_sort

		int[] input = new int[] {7, 4, 11, 1, 3, 5};

		//sortUsingReactiveSwap(input);
		sortUsingInPlaceSwap(input);

		System.out.print("Sorted array: ");
		printIntArray(input);

	}

	private static void sortUsingReactiveSwap(int[] input) {
		for (int i=1; i < input.length; i++) {
			int j = i;
			int x;
			while (j>0 && input[j] < input[j-1]) {
				//swap j and (j-1)
				x = input[j-1];
				input[j-1] = input[j];
				input[j] = x;
				j--;
			}
			System.out.print("Input after iteration [" + i + "]: ");
			printIntArray(input);
		}
	}

	private static void sortUsingInPlaceSwap(int[] input) {
		for (int i=1; i < input.length; i++) {
			int j = i;
			int x = input[j];
			while (j > 0 && input[j-1] > x) {
				input[j] = input[j-1];
				j--;
			}
			//put input[j] in correct place
			input[j] = x;
			System.out.print("Input after iteration [" + i + "]: ");
			printIntArray(input);
		}
	}

	private static void sortUsingRecursion(int[] input) {
		for (int i=1; i < input.length; i++) {
			//TODO
			System.out.print("Input after iteration [" + i + "]: ");
			printIntArray(input);
		}
	}

	private static void printIntArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print("" + arr[i] + " ");
		}
		if(arr.length > 0)
			System.out.println();
	}

}
