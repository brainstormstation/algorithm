package com.binarysearch;

/**
 * https://www.lintcode.com/problem/159/?_from=ladder&fromId=161"
 */
public class FindMinInRotatedSortedArray {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        int result = 0;
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + ( end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        result = Math.min(nums[start],nums[end]);
        return result;
    }
}
