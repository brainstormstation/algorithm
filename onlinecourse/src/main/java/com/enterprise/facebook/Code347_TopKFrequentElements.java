package com.enterprise.facebook;

import java.util.*;
import java.util.Map.Entry;

public class Code347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            }
            else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Entry> queue = new PriorityQueue<>((n1, n2)->((int)n2.getValue() - (int)n1.getValue()));
        for (Entry e: map.entrySet()) {
            queue.add(e);
            if (queue.size()>k) {
                queue.poll();
            }
        }
        int[] res = new int[queue.size()];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = (int)queue.poll().getKey();
        }
        return res;
    }
}
