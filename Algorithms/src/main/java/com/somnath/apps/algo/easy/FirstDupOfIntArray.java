package com.somnath.apps.algo.easy;

import java.util.HashMap;
import java.util.Map;

public class FirstDupOfIntArray {

	public static void main(String[] args){

		int[] input_1 = new int[] {1,2,1,2,3,3};
		int[] input_2 = new int[] {2,1,3,5,3,2};
		int[] input_3 = new int[] {1,2,3,4,5,6};

		System.out.println("Naive: input_1 -> firstDup=" + firstDuplicateNaive(input_1));
		System.out.println("Better: input_1 -> firstDup=" + firstDuplicate(input_1));
		System.out.println();

		System.out.println("Naive: input_2 -> firstDup=" + firstDuplicateNaive(input_2));
		System.out.println("Better: input_2 -> firstDup=" + firstDuplicate(input_2));
		System.out.println();

		System.out.println("Naive: input_3 -> firstDup=" + firstDuplicateNaive(input_3));
		System.out.println("Better: input_3 -> firstDup=" + firstDuplicate(input_3));
	}

	// naive approach - brute force - TimeComplexity=O(n^2) SpaceComplexity=O(1)
	public static int firstDuplicateNaive(int[] arr){
		long startTime = System.currentTimeMillis();
		int firstDup = -1;
		int len = arr.length;
		int firstDupIndex = -1;

		for (int i=0; i<len; i++) {
			int noInContext = arr[i];
			for(int j=i+1; j<len; j++){
				if(noInContext == arr[j]){
					if(firstDupIndex == -1 || firstDupIndex > j){
						firstDup = noInContext;
						firstDupIndex = j;
					}
					break;
				}
			}
		}
		long timeTaken = System.currentTimeMillis() - startTime;
		System.out.println("Naive: firstDup=" + firstDup + " firstDupIndex=" + firstDupIndex + "TimeTakenMS=" + timeTaken);
		return firstDup;
	}

	// better approach - go over the array only once - keep track of dups with the help of more space
	// TimeComplexity=O(n) SpaceComplexity=O(n)
	public static int firstDuplicate(int[] arr){
		long startTime = System.currentTimeMillis();
		int firstDup = -1;
		int len = arr.length;
		int firstDupIndex = -1;

		Map<Integer, Integer> dupFirstIndexMap = new HashMap<>();

		for (int i=0; i<len; i++) {
			int noInContext = arr[i];
			if(dupFirstIndexMap.containsKey(noInContext)){
				firstDup = noInContext;
				firstDupIndex = i;
				break;
			} else {
				dupFirstIndexMap.put(noInContext, -1);
			}
		}
		long timeTaken = System.currentTimeMillis() - startTime;
		System.out.println("Better: firstDup=" + firstDup + " firstDupIndex=" + firstDupIndex + "TimeTakenMS=" + timeTaken);
		return firstDup;
	}
}


