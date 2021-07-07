package com.msb.datastructure.basic;

public class XOROperation {

    /**
     * There is only one number has the odd times in the array, please find that number.
     * @param arr
     * @return
     */
    public int findOddTimes(int[] arr) {
        int result = 0;
        for (int i=0; i<arr.length; i++) {
            result ^= arr[i];
        }
        return result;
    }

    /**
     * There are two numbers have the odd times in the arry, please find them all.
     * @param arr
     * @return
     */
    public int[] findTwoOddTimes(int[] arr) {
        return null;
    }

    public int bitCount(int n) {
        int count = 0;
        while (n!=0) {
            int right = n & ((~n)+1);
            count++;
            n ^= right;
        }
        return count;
    }
    
}
