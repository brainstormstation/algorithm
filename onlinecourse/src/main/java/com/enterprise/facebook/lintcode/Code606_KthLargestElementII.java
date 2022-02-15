package com.enterprise.facebook.lintcode;

import java.util.PriorityQueue;

public class Code606_KthLargestElementII {
    /**
     * @param nums: an integer unsorted array
     * @param k: an integer from 1 to n
     * @return: the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        // write your code here
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->(b-a));
        for (int num: nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    public int kthLargetsElement(int[] nums, int k) {
        partition(nums, 0, nums.length-1, nums.length-k);
        return nums[nums.length-k];
    }

    public void partition(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return;
        }

        int left = start;
        int right = end;
        int mid = left+(right-left)/2;
        int pivot = nums[mid];
        while (left<=right) {
            while (left<=right && nums[left]<pivot) {
                left++;
            }
            while (left<=right && nums[right]>pivot) {
                right--;
            }
            if (left<=right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        if (k>=left) {
            partition(nums, left, end, k);
        } else if (k<=right){
            partition(nums, start, right, k);
        }
    }

    private void swap(int[] num, int i, int j) {
        int  tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
