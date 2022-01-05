package com.enterprise.facebook.lintcode;

import java.util.*;

/**
 * Description
 * Given a non-overlapping interval list which is sorted by start point.
 * Insert a new interval into it, make sure the list is still in order and non-overlapping (merge intervals if necessary).
 */
public class Code30_InsertInterval {
    public class Interval {
        public int start;
        public int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    /**
     * @param intervals: Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // write your code here
        intervals.add(newInterval);
        intervals.sort((a, b)->(a.start - b.start));

        List<Interval> result = new ArrayList<>();
        Interval last = null;
        for (Interval interval: intervals) {
            if (last == null || last.end < interval.start) {
                result.add(last);
                last = interval;
            } else {
                last.end = Math.max(last.end, interval.end);
            }
        }
        return result;
    }
}
