package com.enterprise.facebook.leetcode;

/**
 * You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.
 * You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1] (inclusive) 
 * and returns it. The probability of picking an index i is w[i] / sum(w).
 * For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
 */
public class Code528_RandomPickWithWeight {
    int[] prefixSums;
    int totalSum;
    public Code528_RandomPickWithWeight(int[] w) {
        int prefixSum = 0;
        for (int i=0; i<w.length; i++) {
            prefixSum+=w[i];
            this.prefixSums[i] = prefixSum;
        }
        this.totalSum = prefixSum;
    }
    
    public int pickIndex() {
        double target = this.totalSum * Math.random();
        int low = 0, high = this.prefixSums.length;
        while (low < high) {
            int mid = low + (high - low) >> 1;
            if (target > this.prefixSums[mid]) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
