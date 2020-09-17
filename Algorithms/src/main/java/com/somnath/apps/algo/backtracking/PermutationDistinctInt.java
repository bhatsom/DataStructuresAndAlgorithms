package com.somnath.apps.algo.backtracking;

import java.util.*;
import java.util.stream.Collectors;

class PermutationDistinctInt {

  public static void backtrack(int n, int[] nums, List<List<Integer>> output, int first) {
    // if all integers are used up
    if (first == n)
      output.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));

    for (int i = first; i < n; i++) {
      // place i-th integer first in the current permutation
      swap(nums, first, i);
      System.out.println("1-first=" +first + " i=" + i + " nums=" + nums +" output=" + output);

      // use next integers to complete the permutations
      backtrack(n, nums, output, first + 1);
      System.out.println("2-first=" +first + " i=" + i + " nums=" + nums +" output=" + output);

      // backtrack
      swap(nums, first, i);
      System.out.println("3-first=" +first + " i=" + i + " nums=" + nums +" output=" + output);
    }

  }

  private static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> output = new LinkedList<>();
    backtrack(nums.length, nums, output, 0);
    return output;
  }

  public static void main(String[] args) {
    System.out.println("Permutations: " + permute(new int[]{1,2,3}));
  }

}