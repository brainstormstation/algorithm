package com.enterprise.facebook.leetcode;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * Description:
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:
 * [4,5,6,7,0,1,4] if it was rotated 4 times.
 * [0,1,4,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.
 * You must decrease the overall operation steps as much as possible.
 */
public class Code154_FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if (nums == null || nums.length ==0) {
            return 0;
        }

        int start = 0;
        int end = nums.length -1;
        while (start+1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[start]) {
                end = mid;
            } else if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                end--;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}
