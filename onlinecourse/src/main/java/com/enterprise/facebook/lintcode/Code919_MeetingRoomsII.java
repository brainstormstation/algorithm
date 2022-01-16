package com.enterprise.facebook.lintcode;

import java.util.*;

public class Code919_MeetingRoomsII {
    class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(List<Interval> intervals) {
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        int ans = 0, cnt = 0;
        for (Interval i : intervals) {
            int start = i.start, end = i.end;
            tmap.put(start, tmap.getOrDefault(start, 0) + 1);
            tmap.put(end, tmap.getOrDefault(end, 0) - 1);
        }
        for (int k : tmap.keySet()) {
            cnt += tmap.get(k);
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
