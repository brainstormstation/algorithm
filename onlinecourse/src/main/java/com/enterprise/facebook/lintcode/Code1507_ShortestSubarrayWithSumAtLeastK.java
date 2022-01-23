package com.enterprise.facebook.lintcode;

/**
 * https://www.lintcode.com/problem/1507/?utm_source=sc-libao-zyq
 * Description
 * Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.
 * If there is no non-empty subarray with sum at least K, return -1.
 */
public class Code1507_ShortestSubarrayWithSumAtLeastK {
    /**
     * @param A: the array
     * @param K: sum
     * @return: the length
     */
    public int shortestSubarray(int[] A, int K) {
        // Write your code here.
        if (A == null || A.length == 0) {
            return -1;
        }
        if (A.length == 1) {
            return K == A[0]?1:-1;
        }

        int[][] dp = new int[A.length][A.length];
        int sum = 0;
        for (int i=0; i<A.length ;i++) {
            dp[i][i] = A[i];
            sum += A[i];
            dp[0][i] = sum;
        }

        for (int i=1; i<A.length; i++) {
            for (int j=i+1; j<A.length; j++) {
                dp[i][j] = dp[i-1][j]-dp[i-1][j-1]+dp[i][j-1];
            }
        }

        int minDis = Integer.MAX_VALUE;
        for (int i=0; i<A.length; i++) {
            for (int j=i; j<A.length; j++) {
                if (dp[i][j] >= K && j-i+1 < minDis) {
                    minDis = j-i+1;
                }
            }
        }
        if (minDis == Integer.MAX_VALUE) {
            return -1;
        }
        return minDis;
    }
}
