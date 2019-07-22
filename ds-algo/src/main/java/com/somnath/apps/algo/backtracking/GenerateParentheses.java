package com.somnath.apps.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    private static void backtrack(List<String> ans, String cur, int open, int close, int n) {
        if (cur.length() == n * 2) {
            ans.add(cur);
            return;
        }

        if (open < n)
            backtrack(ans, cur+"(", open+1, close, n);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, n);
    }

    public static void main(String[] args) {

        /*
            n = 3
            1: "" 0 0 -> ( 1 0 -> close = open
            2: (  1 0 ->
                        a. open < n -> (( 2 0
                        b. close < open -> () 1 1
                            a:
                                a1 open < n -> ((( 3 0
                                a2 close < open -> (() 2 1
                            b:
                                b1 open < n -> ()( 2 1
                                b2 close !< open -> END
                                    a1:
                                        - open !< n -> END
                                        - close < open -> ((() 3 1
                                    a2:
                                        - open < n -> (()( 3 1
                                        - close < open -> (()) 2 2
                                    b1:
                                        -
                                        -
                                    b2:
                                        -
                                        -

         */

        /*
         Complexity: 1 + 2 + 4 + ...N = 2^N -1 = O(2^N)
          */

        System.out.println("Combinations:" + generateParenthesis(3));
    }

}