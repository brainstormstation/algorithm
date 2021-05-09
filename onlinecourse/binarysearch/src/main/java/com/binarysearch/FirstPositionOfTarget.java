package com.binarysearch;

/**
 *  https://www.lintcode.com/problem/first-position-of-target/description"
 */
public class FirstPositionOfTarget {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start+1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }            
        }
        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
