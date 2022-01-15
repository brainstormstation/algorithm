package com.enterprise.facebook.lintcode;

public class Code1745_MonotonicArray {
    /**
     * @param A: a array
     * @return: is it monotonous
     */
    public boolean isMonotonic(int[] A) {
        // Write your code here.
        if (A == null || A.length < 3) {
            return true;
        }
        int start = 0;
        int end = A.length;
        boolean inc = A[start] < A[end];
        while (start<end) {
            if (inc && (A[start]>A[start+1] || A[end]<A[end-1])) {
                return false;
            }
            if (!inc && (A[start]<A[start+1] || A[end]>A[end-1])){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
