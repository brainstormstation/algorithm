package com.enterprise.facebook;

import java.util.*;

public class Code973_KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        return quickSelect(points, k);
    }

    private int[][] quickSelect(int[][] points, int k) {
        int left = 0;
        int right = points.length-1;
        int pivotIndex = points.length;
        while (pivotIndex != k) {
            pivotIndex = partition(points, left, right);
            if (pivotIndex < k){
                left = pivotIndex;
            }
            else {
                right = pivotIndex-1;
            }
        }
        return Arrays.copyOf(points, k);
    }

    private int partition(int[][] points, int left, int right) {
        int[] pivot = points[left + (right-left) / 2];
        int pivotDis = distance(pivot);
        while (left < right) {
            while (left < right && distance(points[left]) < pivotDis) {
                left++;
            }
            while (left < right && distance(points[right]) >= pivotDis) {
                right--;
            }
            if (left < right) {
                int[] tmp = points[left];
                points[left] = points[right];
                points[right] = tmp;
                left++;
                right--;
            }
        }
        return left;

    }

    private int distance(int[] points) {
        return points[0] * points[0] + points[1] * points[1];
    }
}
