package com.msb.datastructure.startup;

public class PreSum {
    private int[] preSum;
    
    public PreSum(int[] arr) {
        int len = arr.length;
        preSum = new int[len];
        preSum[0] = arr[0];

        for (int i = 1; i<arr.length; i++) {
            preSum[i] = preSum[i-1] + arr[i];
        }
    }

    public int rangeSum(int start, int end) {
        return start == 0 ? preSum[start] : (preSum[end] - preSum[start-1]);
    }
    
}
