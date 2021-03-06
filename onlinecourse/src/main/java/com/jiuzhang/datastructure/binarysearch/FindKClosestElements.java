package com.jiuzhang.datastructure.binarysearch;

/**
 * <b>Description</b>
 * <p>
 * Given target, a non-negative integer k and an integer array A sorted in ascending order, 
 * find the k closest numbers to target in A, sorted in ascending order by the difference between the number and target. 
 * Otherwise, sorted in ascending order by number if the difference is same.
 * <p>
 * https://www.lintcode.com/problem/460/?_from=ladder&fromId=161
 */
public class FindKClosestElements {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        int[] result = new int[k];
        if (A == null || A.length == 0) {
            return result;
        }

        int pos = find(A, target);
        if (pos == -1) {
            return result;
        }

        int left = pos - 1;
        int right = pos;
        for (int i = 0; i < k; i++) {
            if (left < 0) {
                result[i] = A[right++];
            }
            else if (right >= A.length) {
                result[i] = A[left--];
            }
            else {
                if (target - A[left] > A[right] - target) {
                    result[i] = A[right++];
                }
                else {
                    result[i] = A[left--];
                }
            }
        }
        return result;
    }

    private int find(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
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
