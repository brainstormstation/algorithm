package com.enterprise.facebook.leetcode;

public class Code136_SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0; 
        for (int num: nums) {
            result ^= num;
        }
        return result;
    }
}
