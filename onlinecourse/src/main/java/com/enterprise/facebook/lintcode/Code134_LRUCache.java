package com.enterprise.facebook.lintcode;

import java.util.*;

public class Code134_LRUCache {
    class LRUNode {
        public int key;
        public int val;
        public LRUNode pre;
        public LRUNode next;
        public LRUNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Map<Integer, LRUNode> map;
    LRUNode head;
    LRUNode tail;
    int capacity;

    /*
    * @param capacity: An integer
    */
    public Code134_LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new LRUNode(0,0);
        tail = new LRUNode(0,0);
        head.next = tail;
        tail.pre = head;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (map.containsKey(key)) {
            LRUNode node = map.get(key);
            if (node.pre != head) {
                moveToHead(node);
            }
            return node.val;
        }
        return -1;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (map.containsKey(key)) {
            LRUNode node = map.get(key);
            if (node.pre != head) {
                moveToHead(node);
            }
            node.val = value;
            map.put(key, node);
            return;
        }

        LRUNode newItem = new LRUNode(key,value);
        map.put(key, newItem);
        addToHead(newItem);
        if (map.size()>capacity) {
            removeTail();
        }
    }

    private void moveToHead(LRUNode node) {
        LRUNode pre = node.pre;
        LRUNode next = node.next;
        pre.next = next;
        next.pre = pre;

        addToHead(node);
    }

    private void addToHead(LRUNode node) {
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private void removeTail() {
        LRUNode node = tail.pre;
        tail.pre = node.pre;
        node.pre.next = tail;  
        map.remove(node.key);      
    }
}
