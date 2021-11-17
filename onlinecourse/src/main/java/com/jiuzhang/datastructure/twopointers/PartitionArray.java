package com.jiuzhang.datastructure.twopointers;

/**
 * <b>Description<b>
 * <p>
 * Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
 * <ul>
 *  <li>All elements < k are moved to the left</li>
 *  <li>All elements >= k are moved to the right</li>
 *  <li>Return the partitioning index, i.e the first index i nums[i] >= k.</li>
 * </ul>
 * https://www.lintcode.com/problem/31/?_from=ladder&fromId=161
 */
public class PartitionArray {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            while (start <= end && nums[start] < k) {
                start++;
            }

            while (start <= end && nums[end] >= k) {
                end--;
            }

            if (start <= end) {
                int tmp = nums[start];
                nums[end] = nums[start];
                nums[start] = tmp;
                start++;
                end--;
            }
        }
        return start;
    }
}
