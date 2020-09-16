package com.somnath.apps.algo.easy;

//https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/508/

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer target, return indices of the two numbers such that they add up to target.
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 */
public class TwoSum {

	//Time complexity : O(n)    Space complexity : O(n)
	public static int[] twoSumTwoPass(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement) };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	//Time complexity : O(n)    Space complexity : O(n)
	public static int[] twoSumSinglePass(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args) {

		int[] nums = new int[] {2, 5, 7, 11, 15};
		int[] result = twoSumTwoPass(nums, 9);
		System.out.println(result[0] + " and " + result[1]);
		result = twoSumSinglePass(nums, 9);
		System.out.println(result[0] + " and " + result[1]);

	}

}
