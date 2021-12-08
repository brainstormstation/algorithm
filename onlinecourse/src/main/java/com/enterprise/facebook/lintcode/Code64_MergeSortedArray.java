package com.enterprise.facebook.lintcode;

/**
 * https://www.lintcode.com/problem/64
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 */
public class Code64_MergeSortedArray {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int p1 = m-1, p2 = n-1;
        int i = A.length -1;
        while (p1>=0 && p2>=0) {
            if (A[p1]>B[p2]) {
                A[i--] = A[p1--];
            } else {
                A[i--] = B[p2--];
            }
        }
        while (p2>=0) {
            A[i--] = B[p2--];
        }
        
    } 
    
}
