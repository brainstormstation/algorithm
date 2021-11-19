package com.common.entity;

public class ListNode {
    public int val;
    public int key;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int key, int val) {
        this(val);
        this.key = key;
    }
}
