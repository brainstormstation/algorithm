package com.jiuzhang.datastructure.twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>Description</b>
 * <p>
 * Given an integer array, find a subarray where the sum of numbers is zero. 
 * Your code should return the index of the first number and the index of the last number.
 * <p>
 * https://www.lintcode.com/ladder/161/
 */
public class SubarraySum {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                result.add(map.get(sum)+1);
                result.add(i);
                return result;
            }
            map.put(sum, i);
        }
        return result;
    }
}
