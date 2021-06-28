package com.lintcode.datastructure.twopointers;

public class QuickSortTemplate {

    public void quickSort(int[] nums) {
        if (nums == null || nums.length ==0) {
            return ;
        }

        quickSort(nums, 0, nums.length-1);
    }
    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int start = left;
        int end = right;
        int pivot = start + (end - start) /2;
        while (start <= end) {
            while (start <= end && nums[start] < nums[pivot]) {
                start ++;
            }

            while (start <= end && nums[end] > nums[pivot]) {
                end --;
            }
            if (start <= end) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                start++;
                end--;
            }
        }

        quickSort(nums, left, end);
        quickSort(nums, start, right);
    }
}
