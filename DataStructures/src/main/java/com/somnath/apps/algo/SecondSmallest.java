package com.somnath.apps.algo;

public class SecondSmallest {

	/* Function to print first smallest and second smallest elements */
	static void print2ndSmallest(int arr[]) {
		int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE, arrSize = arr.length;

		// There should be at least two elements
		if (arrSize < 2) {
			System.out.println("Invalid Input..");
			return;
		}

		for (int i = 0; i < arrSize; i ++) {
			if (arr[i] < first) {
				second = first;
				first = arr[i];
			}

            // If arr[i] is in between first and second then update second
			else if (arr[i] < second && arr[i] != first)
				second = arr[i];
		}

		if (second == Integer.MAX_VALUE)
			System.out.println("There is no second smallest element");
		else
			System.out.println("The smallest element is:" + first + " and second smallest element is:" + second);
	}

	public static void main (String[] args) {

		int arr[] = {12, 13, 1, 10, 34, 1};
		print2ndSmallest(arr);
	}

}
