package com.somnath.apps.sort;

public class MergeSort {

	public static void main(String[] args) {

		//  https://en.wikipedia.org/wiki/Merge_sort

		int[] input = new int[] {7, 4, 11, 1, 3, 5};

		sort(input);

		System.out.print("Sorted array: ");
		printIntArray(input);

	}

	private static void sort(int[] input) {
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
