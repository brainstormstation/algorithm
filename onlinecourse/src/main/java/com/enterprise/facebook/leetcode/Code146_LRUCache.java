package com.enterprise.facebook.leetcode;

import java.util.*;

public class Code146_LRUCache {
    class ListNode {
        private int key;
        private int value;
        ListNode next;
        ListNode pre;
        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    ListNode head;
    ListNode tail;
    int capacity;
    Map<Integer, ListNode> map;

    /*
    * @param capacity: An integer
    */public Code146_LRUCache(int capacity) {
        // do intialization if necessary
        this.head = new ListNode(0, 0);
        this.tail = new ListNode(0, 0);
        this.head.next = this.tail;
        this.tail.pre = this.head;
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            goToTail(node);
            return node.value;
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
            ListNode node = map.get(key);
            goToTail(node);
            node.value = value;
        } else {
            if (map.size() == capacity) {
                removeLast();
            }
            ListNode nodeAdd = new ListNode(key, value);
            goToTail(nodeAdd);
            map.put(key, nodeAdd);
        }
    }

    private void removeLast() {
        ListNode node = this.head.next;
        this.head.next = node.next;
        node.next.pre = this.head;
        map.remove(node.key);
        capacity--;
    }

    private void goToTail(ListNode node) {
        if (node.next == null) {
            ListNode cur = this.tail.pre;
            cur.next = node;
            node.pre = cur;
            node.next = this.tail;
            this.tail.pre = node;
        } else if (node.next != tail){
            ListNode pre = node.pre;
            ListNode next = node.next;
            pre.next = next;
            next.pre = pre;
            node.pre = tail.pre;
            node.next = tail;
            tail.pre = node;
        }
    }
}
