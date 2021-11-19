package com.enterprise.microsoft;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], 
 * return the minimum number of conference rooms required.
 * Example 1:
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Example 2:
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 */
public class Code253_MeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        if (intervals.length == 1) {
            return 1;
        }
        int[] start = new int[intervals[0].length];
        int[] end = new int[intervals[0].length];
        for (int i=0; i<intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int iStart = 0;
        int iEnd = 0;
        int count = 0; 
        int maxcount = 0;
        while (iStart < intervals.length) {
            if (start[iStart] < end[iEnd]) {
                count++;
                maxcount = Math.max(count, maxcount);
                iStart++;
            }
            else if (start[iStart] > end[iEnd]) {
                count--;
                iEnd++;
            }
            else {
                iStart++;
                iEnd++;
            }
        }
        return maxcount;
    }
}
