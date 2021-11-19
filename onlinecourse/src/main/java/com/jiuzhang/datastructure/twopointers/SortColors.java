package com.jiuzhang.datastructure.twopointers;

/**
 * <b>Description</b>
 * <p>
 * Given an array with n objects colored red, white or blue. 
 * Sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * https://www.lintcode.com/problem/148/?_from=ladder&fromId=161
 */
public class SortColors {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        quickSort(nums, 0, nums.length-1);
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int pivod = nums[start + (end - start) / 2];
        while (left <= right) {
            while (left <= right && nums[left] < pivod) {
                left++;
            }
            while (left <= right && nums[right] > pivod) {
                right--;
            }
            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }
}
