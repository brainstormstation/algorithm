package com.enterprise.microsoft;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
public class Code56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        
        Arrays.sort(intervals, (a1, a2) -> (a1[0] - a2[0]));
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int i=1; i<intervals.length; i++) {
            int[] interval = intervals[i];
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval; 
            }
            else {
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }

        return Arrays.copyOf(res, idx+1);
    }
}
