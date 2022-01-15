package com.enterprise.facebook.lintcode;

/**
 * Description
 * Give an integer array，find the longest increasing continuous subsequence in this array.
 * An increasing continuous subsequence:
 * <ul>
 * <li>Can be from right to left or from left to right.</li>
 * <li>Indices of the integers in the subsequence should be continuous.</li>
 * </ul>
 */
public class Code397_LongestContinuousIncreasingSubsequence {
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        if (A == null || A.length ==0) {
            return 0;
        }

        if (A.length == 1) {
            return 1;
        }

        int maxLength = 0;
        int start = 0, end =1 ;
        while (end < A.length) {
            if (A[end]>A[end-1]) {
                while (end < A.length && A[end]>A[end-1]) {
                    end++;
                }
                
            } else {
                while (end < A.length && A[end] <= A[end-1]) {
                    end++;
                }
            }
            int count = end - start;
            maxLength = Math.max(maxLength, count);
            start = end-1;
        }
        return Math.max(maxLength, A.length - start);
    }
}
