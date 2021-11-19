package com.jiuzhang.datastructure.twopointers;

/**
 * 相向指针 (patition in quicksort)
 */
public class TwoPointersTemplate {
    
    public void patition(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;

        // key point 1: pivot is the value, not the index
        int pivot = A[start + (end - start) / 2];

        // key point 2: every time you compare left & right, 
        // it should be: left <= right not left < right

        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left ++;
            }

            while (left <= right && A[right] > pivot) {
                right --;
            }

            if (left < right) {
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;
                left++;
                right--;
            }
        }
    }
}
