package com.enterprise.facebook.lintcode;

/**
 * Description
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 */
public class Code160_FindMinimuminRotatedSortedArrayII {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums == null || nums.length ==0) {
            return 0;
        }
        if (nums.length < 2) {
            return nums[0];
        }
        int start = 0; 
        int end = nums.length-1;
        while (start+1 < end) {
            int mid = start + (end - start)/2;
            if (nums[start] > nums[mid]) {
                end = mid;
            }
            else if (nums[mid] > nums[end]) {
                start = mid;
            }
            else {
                end--;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}
