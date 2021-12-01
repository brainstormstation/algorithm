package com.enterprise.facebook.leetcode;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it can trap after raining.
 */
public class Code42_TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int left = 0;
        int right = height.length-1;
        int leftMax = height[0];
        int rightMax = height[height.length-1];
        int ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                }
                else {
                    ans += leftMax - height[left];
                }
                left ++;
            }
            else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                }
                else {
                    ans += rightMax - height[right];
                }
                right--;
            }
        }
        return ans;
    }
}
