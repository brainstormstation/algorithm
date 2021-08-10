package com.msb.datastructure.basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Greedy {

    class Program {
        int start;
        int end;
        int length;
    }

    /**
     * How to arrange the meeting to get the max arrangement
     * @param programs
     * @return
     */
    public int bestArrange(Program[] programs) {
        if (programs == null || programs.length == 0) {
            return 0;
        }
        Arrays.sort(programs, new Comparator<Program>() {
            @Override
            public int compare(Program p1, Program p2) {
                return p1.end - p2.end;
            }
        });
        int endTime = 0;
        int result = 0;
        for (Program p: programs) {
            if (p.start > endTime) {
                result++;
                endTime = p.end;
            }
        }
        return result;

    }

    public int lessMoney(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (Integer i: arr) {
            queue.add(i);
        }
        int sum = 0;
        int cur = 0;
        while (queue.size() > 1) {
            cur = queue.poll() + queue.poll();
            sum += cur;
            queue.add(sum);
        }
        return sum;
     }
}
