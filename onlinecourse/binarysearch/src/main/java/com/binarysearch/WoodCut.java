package com.binarysearch;

/**
 * 
 * Given n pieces of wood with length L[i] (integer array). 
 * Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. 
 * What is the longest length you can get from the n pieces of wood? Given L & k, 
 * return the maximum length of the small pieces.
 * <p>
 * https://www.lintcode.com/problem/183/?_from=ladder&fromId=161
 */
public class WoodCut {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        int result = 0;
        if (L == null || L.length == 0) {
            return result;
        }
        int maxLen = Integer.MIN_VALUE;
        for (int i=0; i < L.length; i++) {
            maxLen = Math.max(maxLen, L[i]);
        }

        int start = 0;
        int end = maxLen;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (check(L, k, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return check(L, k, end) ? end : start;
    }

    private boolean check(int[] L, int k, int len) {
        int count = 0;
        for (int i=0; i < L.length; i++) {
            count += (L[i] / len);
        }
        return count >= k;
    }
}
