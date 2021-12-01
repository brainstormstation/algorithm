package com.enterprise.facebook.leetcode;

import java.util.HashMap;

/**
 * Given an array of integers nums and an integer k, 
 * return the total number of continuous subarrays whose sum equals to k.
 */
public class Code560_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0, 1);
        for (int i=0 ;i< nums.length ;i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count+= map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum - k, 0) + 1);
        }
        return count;
    }
}