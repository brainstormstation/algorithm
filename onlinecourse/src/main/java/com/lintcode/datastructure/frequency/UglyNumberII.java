package com.lintcode.datastructure.frequency;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * <b>Description</b>
 * <p>
 * Ugly number is a number that only have prime factors 2, 3 and 5.
 * Design an algorithm to find the Nth ugly number. The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 * Note that 1 is typically treated as an ugly number.
 * <p>
 * https://www.lintcode.com/problem/4/?_from=ladder&fromId=161
 */
public class UglyNumberII {
    /**
     * @param n: An integer
     * @return: return a  integer as description.
     */
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.add(1L);

        HashSet<Long> seen = new HashSet<>();
        seen.add(1L);

        int[] factor = new int[] {2, 3, 5};

        long currUgly = 1, newUgly;
        for (int i=0; i<n; i++) {
            currUgly = heap.poll();
            for (int f: factor) {
                newUgly = currUgly * f;
                if (!seen.contains(newUgly)) {
                    seen.add(newUgly);
                    heap.add(newUgly);
                }
            }
        }
        return (int)currUgly;
    }
}
