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
}
