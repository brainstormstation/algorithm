package com.enterprise.facebook.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 * Description
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 */
public class Code15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<nums.length-2; i++) {
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int low = i+1, high = nums.length-1, sum = 0-nums[i];
            while (low < high) {
                int target = nums[low]+nums[high];
                if (target == sum) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low+1]){
                        low++;
                    }

                    while (low < high && nums[high] == nums[high-1]) {
                        high--;
                    }
                    high--;
                    low++;
                } else if (target > sum) {
                    high--;
                } else {
                    low++;
                }
            }        
        }
        return result;
    }
}
