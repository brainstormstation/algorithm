package com.enterprise.facebook.leetcode;

/**
 * There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the buildings in the line.
 * The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without obstructions. Formally, a building has an ocean view if all the buildings to its right have a smaller height.
 * Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.
 */
public class Code1762_BuildingsWithAnOceanView {
    public int[] findBuildings(int[] heights) {
        int maxheight = 0;
        int[] ans = new int[heights.length];
        int index = 0;
        for (int i=heights.length-1; i>=0; i--) {
            if (heights[i]>maxheight) {
                ans[index++] = i;
                maxheight = heights[i];
            }
        }
        int[] res = new int[index];
        int start = 0;
        for (int i=index-1; i>=0;i--) {
            res[start++] = ans[i];
        }
        return res;
    }
}
