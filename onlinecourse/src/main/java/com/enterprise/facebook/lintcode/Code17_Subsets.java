package com.enterprise.facebook.lintcode;

import java.util.*;

/**
 * https://www.lintcode.com/problem/17 
 * Description
 * Given a set with distinct integers, return all possible subsets.
 */
public class Code17_Subsets {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        int start = 0; 
        int end = nums.length;
        backtrack(start, end, new LinkedList<Integer>(), result, nums);
        return result;
    }

    private void backtrack(int start, int end, LinkedList<Integer> input, List<List<Integer>> output, int[] nums) {
        for (int i=start; i<end; i++) {
            input.add(nums[i]);
            output.add(new LinkedList<>(input));
            backtrack(i+1, end, input, output, nums);
            input.removeLast();
        }
    }

    private void process(int index, int[] nums, int start, List<Integer> record, List<List<Integer>> result) {
        if (start == nums.length) {
            return;
        }

        for (int i=index; i<= start; i++) {
            record.add(nums[i]);
        }
        result.add(record);
        process(index, nums, start+1, new ArrayList<Integer>(), result);        
    }
}
