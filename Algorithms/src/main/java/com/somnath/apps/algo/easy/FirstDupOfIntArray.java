package com.somnath.apps.algo.easy;

import java.util.HashSet;
import java.util.Set;

public class FirstDupOfIntArray {

	public static void main(String[] args){

		int[] input_1 = new int[] {1,2,1,2,3,3};
		int[] input_2 = new int[] {2,1,3,5,3,2};
		int[] input_3 = new int[] {1,2,3,4,5,6};

		firstDuplicateNaive(input_1);
		firstDuplicate(input_1);
		System.out.println();

		firstDuplicateNaive(input_2);
		firstDuplicate(input_2);
		System.out.println();

		firstDuplicateNaive(input_3);
		firstDuplicate(input_3);
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
		System.out.println("Naive: firstDup=" + firstDup + " firstDupIndex=" + firstDupIndex + " TimeTakenMS=" + timeTaken);
		return firstDup;
	}

	// better approach - go over the array only once - keep track of dups with the help of more space
	// TimeComplexity=O(n) SpaceComplexity=O(n)
	public static int firstDuplicate(int[] arr){
		long startTime = System.currentTimeMillis();
		int firstDup = -1;
		int firstDupIndex = -1;

		Set<Integer> visitedMap = new HashSet<>();

		for (int i=0; i<arr.length; i++) {
			int noInContext = arr[i];
			if(visitedMap.contains(noInContext)){
				firstDup = noInContext;
				firstDupIndex = i;
				break;
			} else {
				visitedMap.add(noInContext);
			}
		}
		long timeTaken = System.currentTimeMillis() - startTime;
		System.out.println("Better: firstDup=" + firstDup + " firstDupIndex=" + firstDupIndex + " TimeTakenMS=" + timeTaken);
		return firstDup;
	}
}


