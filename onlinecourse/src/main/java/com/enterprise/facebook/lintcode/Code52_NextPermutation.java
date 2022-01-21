package com.enterprise.facebook.lintcode;

public class Code52_NextPermutation {
    /**
     * @param nums: A list of integers
     * @return: A list of integers
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        // write your code here
        if (nums == null || nums.length < 2) {
            return nums;
        }

        int i = nums.length - 2;
        while (i>=0 && nums[i]>=nums[i+1]) {
            i--;
        }

        if (i<0) {
            reverse(nums, 0);
            return nums;
        }

        int j = nums.length - 1;
        while (j>i && nums[j]<=nums[i]) {
            j--;
        }
        swap(nums, i, j);
        reverse(nums, i+1);
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length-1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
