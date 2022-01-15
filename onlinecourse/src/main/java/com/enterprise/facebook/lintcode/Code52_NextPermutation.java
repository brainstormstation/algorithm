package com.enterprise.facebook.lintcode;

public class Code52_NextPermutation {
    /**
     * @param nums: A list of integers
     * @return: A list of integers
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return null;
        }

        int i = nums.length - 2;
        for (; i>=0; i--) {
            if (nums[i]<nums[i+1]) {
                break;
            }
        }

        if (i == -1) {
            reverse(nums, 0, nums.length-1);
        }

        int j = nums.length-1;
        for (; j>i;j--) {
            if (nums[j]>nums[i]) {
                break;
            }
        }
        swap(nums, i, j);

        reverse(nums, i+1, nums.length-1);

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
