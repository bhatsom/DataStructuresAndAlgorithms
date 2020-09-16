package com.somnath.apps.algo.med;

public class MinSortedRotatedArray {

	public static void main(String[] args) {
		int[] testData1 = {5, 6, 1, 2, 3, 4};
		int[] testData2 = {1, 2, 3, 4};
		int[] testData3 = {3, 2};
		int[] testData4 = {5, 7, 4};

		System.out.println("MIN 1: " + findMin1(testData1));
		System.out.println("MIN 12: " + findMin2(testData1, 0, testData1.length-1));
		System.out.println("MIN 2: " + findMin1(testData2));
		System.out.println("MIN 22: " + findMin2(testData2, 0, testData2.length-1));
		System.out.println("MIN 3: " + findMin1(testData3));
		System.out.println("MIN 32: " + findMin2(testData3, 0, testData3.length-1));
		System.out.println("MIN 4: " + findMin1(testData4));
		System.out.println("MIN 42: " + findMin2(testData4, 0, testData4.length-1));
	}

	// O(N) - needs traversing the whole array
	private static int findMin1(int[] arr){
		int min = -1;

		if(arr == null || arr.length < 1)
			return min;
		if(arr.length == 1)
			return arr[0];

		min = arr[0];
		for (int i=1; i<arr.length; i++) {
			int temp = arr[i];
			if (temp < min) {
				min = temp;
				break;
			}
		}

		return min;
	}

	//O(logN)
	private static int findMin2(int arr[], int low, int high) {
		//{5, 6, 2, 3, 4}
		//{5, 6, 1, 2, 3, 4}
		// condition to handle the case when array is not rotated at all
		if (high < low)  return arr[0];

		// if there is only one element left
		if (high == low) return arr[low];

		// find mid index
		int mid = low + (high - low)/2; /*(low + high)/2;*/

		// is element (mid+1) is minimum element? Consider the cases like {3, 4, 5, 1, 2}
		if (mid < high && arr[mid+1] < arr[mid])
			return arr[mid+1];

		// is mid itself is minimum element
		if (mid > low && arr[mid] < arr[mid - 1])
			return arr[mid];

		//{5, 6, 1, 2, 3, 4}
		// Decide whether we need to go to left half or right half
		if (arr[high] > arr[mid])
			return findMin2(arr, low, mid-1);

		return findMin2(arr, mid+1, high);
	}

}
