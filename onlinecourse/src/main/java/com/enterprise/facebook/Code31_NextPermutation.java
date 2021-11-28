package com.enterprise.facebook;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.
 */
public class Code31_NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int i = nums.length-2;
        for (; i>=0; i--) {
            if (nums[i] < nums[i+1]) {
                break;
            }
        }

        if (i == -1) {
            reverse(nums, 0);
            return;
        }

        int j = nums.length - 1;
        for (;j>i;j--) {
            if (nums[j] > nums[i]) {
                break;
            }
        }

        swap(nums, i, j);

        reverse(nums,i);
    }

    private void swap(int[] arr,int i,int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    private void reverse(int[] arr, int start) {
        int left = start; 
        int right = arr.length-1;
        while (left < right) {
            swap(arr, left++, right--);
        }
    }
}

