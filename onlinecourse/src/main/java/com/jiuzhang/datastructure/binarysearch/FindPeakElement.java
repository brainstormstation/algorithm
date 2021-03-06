package com.jiuzhang.datastructure.binarysearch;

/**
 * https://www.lintcode.com/problem/75/?_from=ladder&fromId=161
 */
public class FindPeakElement {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if (A == null || A.length < 3) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid-1] < A[mid] && A[mid] > A[mid+1]) {
                return mid;
            } else if (A[mid-1] < A[mid] && A[mid] < A[mid+1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        return A[start] > A[end] ? start: end;
    }
}
