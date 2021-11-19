package com.lintcode.datastructure.memorysearch;

/**
 * <b>Description</b>
 * <p>
 * A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time. 
 * Implement a method to count how many possible ways the child can run up the stairs.
 * <p>
 * https://www.lintcode.com/problem/272/?_from=ladder&fromId=161
 */
public class ClimbingStairsII {
    /**
     * @param n: An integer
     * @return: An Integer
     */
    public int climbStairs2(int n) {
        // write your code here
        if ( n <= 1) {
            return 1;
        }
        if ( n == 2) {
            return 2;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<n+1; i++) {
            dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
        }
        return dp[n];
    }
}
