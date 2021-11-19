package com.jiuzhang.datastructure.twopointers;

import java.util.Arrays;

/**
 * 
 * Given an array of integers, 
 * find how many unique pairs in the array such that their sum is equal to a specific target number. 
 * Please return the number of pairs.
 * <p>
 * https://www.lintcode.com/problem/587/?_from=ladder&fromId=161
 */
public class TwoSumUniquePairs {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 2) return nums[0] + nums[1] == target? 1 : 0;

        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int count = 0;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if ( sum == target) {
                start ++;
                end --;
                count ++;
                while (start<end && nums[start] == nums[start-1]) {
                    start++;
                }
                while (start<end && nums[end] == nums[end+1]) {
                    end--;
                }
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
            
        }
        return count;
    }
    
}
