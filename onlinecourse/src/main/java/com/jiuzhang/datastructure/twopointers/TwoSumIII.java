package com.lintcode.datastructure.twopointers;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a TwoSum class. 
 * It should support the following operations: add and find.
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * <p>
 * https://www.lintcode.com/problem/607/?_from=ladder&fromId=161
 */
public class TwoSumIII {

    private Map<Integer, Integer> counter;

    public TwoSumIII () {
        this.counter = new HashMap<>();
    }
    /**
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        counter.put(number, counter.getOrDefault(number, 0) + 1);
        
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (Integer num: this.counter.keySet()) {
            int rest = value - num;
            int desireCount = num == rest ? 2 : 1;
            if (this.counter.getOrDefault(rest, 0) >= desireCount) {
                return true;
            }
        }
        return false;
    }
}
