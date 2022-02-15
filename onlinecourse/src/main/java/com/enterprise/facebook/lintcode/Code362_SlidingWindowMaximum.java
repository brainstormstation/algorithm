package com.enterprise.facebook.lintcode;

import java.util.*;

/**
 * https://www.lintcode.com/problem/362/?utm_source=sc-libao-zyq
 * 
 * Description
 * Given an array of n integer with duplicate number, and a moving window(size k), 
 * move the window at each iteration from the start of the array, 
 * find the maximum number inside the window at each moving.
 */
public class Code362_SlidingWindowMaximum {
    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;
        Deque<Integer> maxQueue = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        while (end < nums.length) {
            if (end-start+1<=k) {
                max = Math.max(max, nums[end]);
                maxStack.push(max);
                end++;
                continue;
            }
            start++;
            result.add(maxStack.pop());
            max = Math.max(maxStack.peek(), nums[end]);
            maxStack.push(max);
            end++;
        }
        result.add(maxStack.peek());
        return result;
    }
}
