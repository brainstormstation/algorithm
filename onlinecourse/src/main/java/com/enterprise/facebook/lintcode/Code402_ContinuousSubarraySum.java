package com.enterprise.facebook.lintcode;

import java.util.*;

/**
 * Description
 * Given an integer array, find a continuous subarray where the sum of numbers is the biggest. 
 * Your code should return the index of the first number and the index of the last number. 
 * (If their are duplicate answer, return the minimum one in lexicographical order)
 */
public class Code402_ContinuousSubarraySum {
    /*
     * @param A: An integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> continuousSubarraySum(int[] A) {
        // write your code here
        int first=0, last=0;
        int sum=0, maxSum=A[0], bg=0;
        for (int i=0; i<A.length; i++) {
            if (sum>=0) {
                sum+=A[i];
            } else {
                bg=i;
                sum=A[i];
            }
            if (maxSum<sum) {
                maxSum=sum;
                first=bg;
                last=i;
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(first);
        result.add(last);
        return result;

    }
}
