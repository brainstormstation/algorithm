package com.enterprise.facebook.lintcode;

/**
 * Description
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 */
public class Code363_TrappingRainWater {
    /**
     * @param heights: a list of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        int count = 0;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int start = 0;
        int end = heights.length-1;
        while (start < end) {
            if (heights[start]<heights[end]) {
                if (heights[start]>leftMax) {
                    leftMax = heights[start];
                }
                else {
                    count += leftMax - heights[start];
                }
                start++;

            }
            else {
                if (heights[end]>rightMax) {
                    rightMax = heights[end];
                }
                else {
                    count += rightMax - heights[end];
                }
                end--;
            }
            
        }
        return count;
    }
}
