package com.enterprise.facebook.lintcode;

import java.util.*;

/**
 * Description
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 */
public class Code838_SubarraySumEqualsK {
    /**
     * @param nums: a list of integer
     * @param k: an integer
     * @return: return an integer, denote the number of continuous subarrays whose sum equals to k
     */
    public int subarraySumEqualsK(int[] nums, int k) {
        // write your code here
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum+=nums[i];
            int rest = sum - k;
            if (map.containsKey(rest)) {
                count+=map.get(rest);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
    
}
