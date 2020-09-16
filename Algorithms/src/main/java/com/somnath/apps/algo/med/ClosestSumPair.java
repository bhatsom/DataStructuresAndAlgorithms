package com.somnath.apps.algo.med;

//https://www.geeksforgeeks.org/given-sorted-array-number-x-find-pair-array-whose-sum-closest-x/

/**
 * Given a sorted array and a number x, find a pair in array whose sum is closest to x.
 *
 * Input: arr[] = {10, 22, 28, 29, 30, 40}, x = 54
 * Output: 22 and 30
 *
 * Input: arr[] = {1, 3, 4, 7, 10}, x = 15
 * Output: 4 and 10
 */
public class ClosestSumPair {

	public static void main(String[] args) {
		int[] arr =  {10, 22, 28, 29, 30, 40};
		int[] arr2 =  {1, 3, 4, 7, 10};
		closestPair(arr, 54);
		closestPair(arr2, 15);
	}

	//sliding window approach - Time complexity : O(n)    Space complexity : O(1)
	public static void closestPair(int arr[], int x) {
		int res_l=0, res_r=0;
		int l = 0, r = arr.length-1, diff = Integer.MAX_VALUE;

		while (r > l) {
			// Check if this pair is closer than the closest pair so far
			if (Math.abs(arr[l] + arr[r] - x) < diff) {
				res_l = l;
				res_r = r;
				diff = Math.abs(arr[l] + arr[r] - x);
			}

			// If the sum is bigger than the target, move to smaller values
			if ((arr[l] + arr[r]) > x)
				r--;
			else // Move to larger values
				l++;
		}

		System.out.println(" The closest pair is: " + arr[res_l] + " and " +arr[res_r]);
	}

}
