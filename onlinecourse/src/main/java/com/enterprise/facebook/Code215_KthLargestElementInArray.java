package com.enterprise.facebook;

import java.util.*;

public class Code215_KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2)->(n1-n2));
        for (int i=0; i<nums.length; i++) {
            heap.add(nums[i]);
            if (heap.size()>k) {
                heap.poll();
            }
        }
        return heap.poll();
    }
    
}
