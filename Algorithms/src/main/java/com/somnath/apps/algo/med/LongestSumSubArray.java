package com.somnath.apps.algo.med;

public class LongestSumSubArray {

	private static final int NO_OF_CHARS;

	static {
		NO_OF_CHARS = 256;
	}

	public static int[] longestSumSubArray(int n, int[] arr) {
		int[] result = new int[]{-1};
		int len = arr.length;
		if(len < 1) {
			System.out.println("Empty array not allowed");
			return result;
		}

		int startIndx = 0, endIndx = 0;
		int startIndxFinal = -1, endIndxFinal = -1;
		int sum = 0;
		boolean subArrayFound = false;
		boolean endIndexReachedEnd = false;

		while(startIndx < len && endIndx < len){
			sum += arr[endIndx];
			System.out.println("startIndx=" + startIndx + " endIndx=" + endIndx + " sum=" + sum);

			while(sum > n && startIndx < endIndx) {
				sum -= arr[startIndx];
				startIndx++;
			}

			if(sum == n){
				System.out.println("Target sum found. startIndx=" + startIndx + " endIndx=" + endIndx);
				// check if the diff betwn startIndx and endIndx > any previously computed subarray length
				if(subArrayFound) {
					if((endIndx - startIndx) > (endIndxFinal - startIndxFinal)){
						startIndxFinal = startIndx;
						endIndxFinal = endIndx;
					}
				} else { // IF no previously computed subarray found THEN store this subarray as the result
					subArrayFound = true;
					startIndxFinal = startIndx;
					endIndxFinal = endIndx;
				}

				// moving startIndx forward is worthless now - it only makes the subarray smaller
				if(endIndexReachedEnd)
					break;
			}
			//endIndx++;

			if(endIndx < len){
				endIndx++;
			} else {
				if(!endIndexReachedEnd){
					System.out.println("End Index has reached to the END");
					endIndexReachedEnd = true;
				}
			}
		}

		if(subArrayFound) {
			result = new int[endIndxFinal - startIndxFinal + 1];
			for(int i=startIndxFinal,j=0; i<=endIndxFinal; i++,j++)
				result[j] = arr[i];
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,0,0,0,6,7,8,9,10};
		//int[] arr = new int[] {1,2,3,4,5,1,-1,0,6,7,8,9,10};

		int[] subArray = longestSumSubArray(15, arr);
		System.out.print("The longest non repeating character is: ");
		for(int i=0; i<subArray.length; i++)
			System.out.print(" " + subArray[i]);
	}

}
