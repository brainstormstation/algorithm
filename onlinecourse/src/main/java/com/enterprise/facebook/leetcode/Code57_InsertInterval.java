package com.enterprise.facebook.leetcode;

import java.util.*;

/**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] 
 * represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. 
 * You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti 
 * and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * Return intervals after the insertion.
 */
public class Code57_InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int n = intervals.length;
        LinkedList<int[]> result = new LinkedList<>();
        int idx = 0;
        while (idx < n && newStart > intervals[idx][0]) {
            result.add(intervals[idx++]);
        }

        int[] interval = new int[2];
        if (result == null || result.getLast()[1] < newStart) {
            result.add(newInterval);
        } else {
            interval = result.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            result.add(interval);
        }

        while (idx < n) {
            interval = intervals[idx];
            int start = interval[0];
            int end = interval[1];
            if (result.getLast()[1] < start) {
                result.add(interval);
            } else {
                interval = result.removeLast();
                interval[1] = Math.max(interval[1], end);
                result.add(interval);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
