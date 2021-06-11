package com.lintcode.datastructure.frequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * <b>Description</b>
 * <p>
 * Design a data structure that supports all following operations in average O(1) time.
 * <ul>
 * <li>insert(val): Inserts an item val to the set if not already present.</li>
 * <li>remove(val): Removes an item val from the set if present.</li>
 * <li>getRandom: Returns a random element from current set of elements. </li>
 * </ul>
 * <p>
 * Each element must have the same probability of being returned.
 * <p>
 * https://www.lintcode.com/problem/657/?_from=ladder&fromId=161
 */
public class InsertDeleteGetRandom {
    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param = obj.insert(val);
     * boolean param = obj.remove(val);
     * int param = obj.getRandom();
     */

    List<Integer> list;
    Map<Integer, Integer> map;
    Random random;

    public InsertDeleteGetRandom() {
        // do intialization if necessary
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        // write your code here
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size());
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        // write your code here
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        Collections.swap(list, index-1, list.size()-1);
        map.put(list.get(list.size()-1), index);
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        // write your code here
        int random = this.random.nextInt(list.size());
        return list.get(random);
    }
    
}
