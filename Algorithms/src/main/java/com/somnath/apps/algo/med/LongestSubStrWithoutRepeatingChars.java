package com.somnath.apps.algo.med;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStrWithoutRepeatingChars {

	public static void main(String[] args) {
		//String str = "ABDEFGABEF";
		String str = "ABCCDFG";
		System.out.println("The input string is: " + str);
		//int len = longestNonRepSubStr1(str);
		//System.out.println("The length of the longest non repeating character is: " + len);

		int len2 = longestNonRepSubStr2(str);
		System.out.println("The length of the longest non repeating character is: " + len2);
	}

	//O(N^3) - brute force
	public static int longestNonRepSubStr1(String s) {
		int n = s.length();
		int ans = 0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j <= n; j++)
				if (allUnique(s, i, j))
					ans = Math.max(ans, j - i);
		return ans;
	}

	private static boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for (int i = start; i < end; i++) {
			Character ch = s.charAt(i);
			if (set.contains(ch)) return false;
			set.add(ch);
		}
		return true;
	}

	// O(N) - sliding window approach
	public static int longestNonRepSubStr2(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		int currMaxLen = 0, currMaxStart = 0, currMaxEnd = 0;
		while (i < n && j < n) {
			// try to extend the range [i, j]
			if (!set.contains(s.charAt(j))){
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
				if(ans > currMaxLen) {
					currMaxLen = ans;
					currMaxStart = i;
					currMaxEnd = j;
				}
			}
			else {
				set.remove(s.charAt(i++));
			}
 			System.out.println("i="+i+" j="+j+" set:"+set);
		}
		System.out.println("currMaxLen="+currMaxLen+" currMaxStart="+currMaxStart+" currMaxEnd="+(currMaxEnd-1));
		System.out.println("Max NonRepeating SubStr:" + s.substring(currMaxStart, currMaxEnd));
		return ans;
	}

}
