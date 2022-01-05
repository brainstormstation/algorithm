package com.enterprise.facebook.lintcode;

import java.util.*;

/**
 * Description
 * Given a collection of intervals, merge all overlapping intervals.
 */
public class Code156_MergeIntervals {
    public class Interval {
        public int start;
        public int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    /**
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> result = new ArrayList<>();        
        intervals.sort((a, b)->(a.start - b.start));
        Interval last = null;
        for (Interval interval : intervals) {
            if (last == null || last.end < interval.start) {
                result.add(interval);
                last = interval;
            }
            else {
                last.end = Math.max(last.end, interval.end);
            }
        }
        return result;
    }
}
