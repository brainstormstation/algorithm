package com.enterprise.facebook.leetcode;

import java.util.Deque;

/**
 * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
 * Given an integer array nums and an integer k, return the length of the shortest non-empty subarray of nums with a sum of at least k. If there is no such subarray, return -1.
 * A subarray is a contiguous part of an array.
 */
public class Code862_ShortestSubarrayWithSumAtLeastK {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        Deque<long[]> dq = new ArrayDeque<long[]>();
        dq.offer(new long[]{-1,0});
        int i = 0;
        long curSum = 0;
        int res = Integer.MAX_VALUE;
        while(i < nums.length)
        {
            curSum += nums[i];
            while(!dq.isEmpty() && dq.peekFirst()[1] <= curSum - k) res = Math.min(res, (int)(i - dq.pollFirst()[0]));
            while(!dq.isEmpty() && dq.peekLast()[1] >= curSum) dq.pollLast();
            dq.offerLast(new long[]{i, curSum});
            i++;
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
