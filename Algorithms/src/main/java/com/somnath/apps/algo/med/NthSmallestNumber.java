package com.somnath.apps.algo.med;


/**
 * Input: arr[] = {7, 10, 4, 3, 20, 15} N = 3
 * Output: 7
 *
 * Input: arr[] = {7, 10, 4, 3, 20, 15} N = 4
 * Output: 10
 */

public class NthSmallestNumber {

	public static void main(String[] args) {
		int[] arr = {7, 10, 4, 3, 20, 15};
		nthSmallestNumber(arr, 0, arr.length, 3);
	}

	/**
	 *
	 * Method = QuickSelect
	 * This is an optimization over method 1 if QuickSort is used as a sorting algorithm in first step. In QuickSort,
	 * we pick a pivot element, then move the pivot element to its correct position and partition the array around it.
	 * The idea is, not to do complete quicksort, but stop at the point where pivot itself is k’th smallest element.
	 *
	 * Also, not to recur for both left and right sides of pivot, but recur for one of them according to the position
	 * of pivot. The worst case time complexity of this method is O(n2), but it works in O(n) on average.
	 */
	// Time complexity: AVG=O(n) WORST=O(N^2)  Space complexity : O(1)
	// This function returns k'th smallest element in arr[l..r] using QuickSort based method.
	// ASSUMPTION: ALL ELEMENTS IN ARR[] ARE DISTINCT
	public static int nthSmallestNumber(int arr[], int l, int r, int n) {
		// If n is smaller than number of elements in array
		if (n > 0 && n <= (r - l + 1)) {
			// Partition the array around last element and get position of pivot element in sorted array
			int pivot = partition(arr, l, r);

			// If position is same as k
			if ( (pivot - l) == (n - 1) )
				return arr[pivot];

			// If val at position is higher than target, recur for left sub-array
			if ((pivot - l) > (n - 1) )
				return nthSmallestNumber(arr, l, pivot - 1, n);

			// Else recur for right sub-array
			return nthSmallestNumber(arr, (pivot + 1), r, (n - (pivot + l) - 1));
		}

		// If n is more than number of elements in array
		return Integer.MAX_VALUE;
	}

	public static int partition(int[] arr, int l, int r) {
		int x = arr[r], i = l;
		for (int j = l; j <= r - 1; j++) {
			if (arr[j] <= x) {
				// Swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
		}

		// Swap arr[i] and arr[r]
		int temp = arr[i];
		arr[i] = arr[r];
		arr[r] = temp;

		return i;
	}
}
