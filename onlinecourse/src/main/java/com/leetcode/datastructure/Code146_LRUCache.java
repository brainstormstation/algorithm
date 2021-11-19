package com.leetcode.datastructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 *  Implement the LRUCache class:

 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 * 
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <a>https://leetcode.com/problems/lru-cache/</a>
 */
public class Code146_LRUCache {
    Queue<Integer> queue;
    int size;
    HashMap<Integer, Integer> cache;
    public Code146_LRUCache(int capacity) {
        this.size = capacity;
        queue = new LinkedList<>();
        cache = new HashMap<>();
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            int output = cache.get(key);
            if (queue.size() == size) {
                int result = queue.poll();
                if (result != key) {
                    cache.remove(key);
                }
            }
            return output;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        
    }
}
