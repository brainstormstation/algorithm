package com.msb.datastructure.interviewquestion;

import java.util.*;

import com.common.entity.DoubleNode;

public class LRUCache {
    private HashMap<Integer, DoubleNode> map;
    int capacity = 0;
    int size = 0;
    DoubleNode header;
    DoubleNode tail;

    public LRUCache (int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DoubleNode node = map.get(key);
        moveToTail(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoubleNode node = map.get(key);
            moveToTail(node);
        }
        else {
            DoubleNode node = new DoubleNode(key, value);
            if (header == null) {
                header = node;
                tail = node;                
            }
            else {
                if (size == capacity) {
                    header = header.next;
                    header.pre = null;
                    size-- ;
                }

                tail.next = node;
                node.pre = tail;
                tail = node;
                size++;
            }
        }
    }

    private void moveToTail(DoubleNode node) {
        if (node == tail) {
            return;
        }

        DoubleNode pre = node.pre;
        DoubleNode next = node.next;
        pre.next = next;
        next.pre = pre;
        node.next = null;
        node.pre = null;

        tail.next = node;
        node.pre = tail;
        tail = node;
    }

}
