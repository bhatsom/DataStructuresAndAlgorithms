package com.somnath.apps.algo;

import java.util.*;

public class FormLargestNumber {

	public static void printLargest(List<Integer> arr){

		Collections.sort(arr, new Comparator<Integer>(){
			@Override
			public int compare(Integer x, Integer y) {
				String xy = "" + x + y;
				String yx = "" + y + x;
				return yx.compareTo(xy);
				//return xy.compareTo(yx) > 0 ? -1 : 1;
			}
		});

		Iterator it = arr.iterator();
		while(it.hasNext())
			System.out.print(it.next());
	}

	public static String largestNumber(int[] nums) {
		String[] arr = new String[nums.length];
		for(int i=0; i<nums.length; i++){
			arr[i]=String.valueOf(nums[i]);
		}

		Arrays.sort(arr, new Comparator<String>(){
			public int compare(String a, String b){
				return (b+a).compareTo(a+b);
			}
		});

		StringBuilder sb = new StringBuilder();
		for(String s: arr){
			sb.append(s);
		}

		while(sb.charAt(0) == '0' && sb.length()>1)
			sb.deleteCharAt(0);

		return sb.toString();
	}

	public static void main(String[] args) {
		int[] testNumbers = new int[]{1, 34, 3, 98, 9, 76, 45, 4};
		System.out.println("Largest number using largestNumber(): " + largestNumber(testNumbers));

		List<Integer> numbers = Arrays.asList(1, 34, 3, 98, 9, 76, 45, 4);
		System.out.print("Largest number using printLargest(): ");
		printLargest(numbers);
	}}
