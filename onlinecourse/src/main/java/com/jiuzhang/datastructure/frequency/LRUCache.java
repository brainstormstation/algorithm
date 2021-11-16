package com.lintcode.datastructure.frequency;

import java.util.HashMap;
import java.util.Map;

class ListNode {
    public int key, val;
    public ListNode next;
    
    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
    }
}
/**
 * <b>Description</b>
 * <p>
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * <ul>
 * <li>get(key) Get the value (will always be positive) of the key if the key exists in the cache, othewise return -1.</li>
 * <li>set(key, value) Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <ul>
 * <p>
 * Finally, you need to return the data from each get.
 * <p>
 * https://www.lintcode.com/problem/134/?_from=ladder&fromId=161
 */
public class LRUCache {
    private int capacity, size;
    private ListNode dummy, tail;
    private Map<Integer, ListNode> keyToPrev;
    /*
    * @param capacity: An integer
    */public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        this.keyToPrev = new HashMap<>();
        this.dummy = new ListNode(0,0);
        this.tail = dummy;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        if (!keyToPrev.containsKey(key)) {
            return -1;
        }
        moveToTail(key);
        return tail.val;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (get(key) != -1) {
            ListNode prev = keyToPrev.get(key);
            prev.next.val = value;
            return;
        }

        if (size < capacity) {
            size++;
            ListNode cur = new ListNode(key, value);
            tail.next = cur;
            keyToPrev.put(key, tail);
            tail = cur;
            return;
        }

        ListNode first = dummy.next;
        keyToPrev.remove(first.key);
        first.key = key;
        first.val = value;
        keyToPrev.put(key, dummy);
        moveToTail(key);
    }

    private void moveToTail(int key) {
        ListNode prv = keyToPrev.get(key);
        ListNode cur = prv.next;

        if (tail == cur) {
            return;
        }

        prv.next = prv.next.next;
        tail.next = cur;
        cur.next = null;

        if (prv.next != null) {
            keyToPrev.put(prv.next.key, prv);
        }
        keyToPrev.put(cur.key, tail);
        tail = cur;
    }
}
