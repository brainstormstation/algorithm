package com.enterprise.microsoft;

import java.util.HashMap;

import com.common.entity.DoubleNode;

public class LRUCache {
    int capacity = 0;
    DoubleNode head;
    DoubleNode tail;
    HashMap<Integer, DoubleNode> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DoubleNode(0, 0);
        tail = new DoubleNode(0, 0);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DoubleNode node = map.get(key);
        removeNode(node);
        addToFirst(node);
        return node.val;
    }

    public void put(int key, int value) {
        DoubleNode node = new DoubleNode(key, value);
        if (map.containsKey(key)) {
            removeNode(map.get(key));

            addToFirst(node);
            return;
        }

        if (map.size() == capacity) {
            map.remove(tail.pre.key);
            removeNode(tail.pre);
        }

        addToFirst(node);
    }

    private void removeNode(DoubleNode node) {
        DoubleNode pre = node.pre;
        DoubleNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    private void addToFirst(DoubleNode node) {

        map.put(node.key, node);
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }
}
