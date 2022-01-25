package com.enterprise.facebook.leetcode;

/**
 * https://leetcode.com/problems/rectangle-area/
 * Description:
 * Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the two rectangles.
 * The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).
 * The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).
 */
public class Code223_RectangleArea {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int first = Math.abs((ax1-ax2)*(ay1-ay2));
        int second = Math.abs((bx1-bx2)*(by1-by2));

        int commX = Math.min(ax2, bx2)-Math.max(ax1, bx1);
        int commY = Math.min(ay2, by2)-Math.max(ay1, by1);
        commX = commX<0?0:commX;
        commY = commY<0?0:commY;
        return first+second-commX*commY;

    }
}
