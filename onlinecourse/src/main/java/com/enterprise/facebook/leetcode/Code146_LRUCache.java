package com.enterprise.facebook.leetcode;

import java.util.*;

public class Code146_LRUCache {
    class LRUNode {
        public int key;
        public int val;
        public LRUNode pre;
        public LRUNode next;
        public LRUNode (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Map<Integer, LRUNode> map;
    LRUNode head;
    LRUNode tail;
    int capacity;
    
    public Code146_LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new LRUNode(0, 0);
        tail = new LRUNode(0, 0);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        LRUNode node = getNode(key);
        if (node != null) {
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        LRUNode node = getNode(key);
        if (node != null) {
            node.val = value;
            map.put(key, node);
            return;
        }

        node = new LRUNode(key, value);
        map.put(key, node);
        addToHead(node);
        if (map.size() > capacity) {
            removeTail();
        }

    }

    private void removeTail() {
        LRUNode node = tail.pre;
        tail.pre = node.pre;
        node.pre.next = tail;
        map.remove(node.key);
    }

    private void addToHead(LRUNode node) {
        LRUNode next = head.next;
        head.next = node;
        node.next = next;
        node.pre = head;
        next.pre = node;
    }

    private LRUNode getNode(int key) {
        if (map.containsKey(key)) {
            LRUNode node = map.get(key);
            if (node.pre != head) {
                moveToHead(node);
            }
            return node;
        }
        return null;
    }
    
    private void moveToHead(LRUNode node) {
        LRUNode pre = node.pre;
        LRUNode next = node.next;
        pre.next = next;
        next.pre = pre;
        addToHead(node);
    }
}
