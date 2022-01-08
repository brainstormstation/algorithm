package com.enterprise.facebook.lintcode;

/**
 * Description
 * Given 2 * n + 1 numbers, every numbers occurs twice except one, find it.
 */
public class Code82_SingleNumber {
    public int singleNumber(int[] A) {
        int result = 0;
        for (int i=0; i<A.length; i++) {
            result ^= A[i];
        }
        return result;
    }
}
