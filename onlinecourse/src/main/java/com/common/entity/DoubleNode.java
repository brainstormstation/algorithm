package com.common.entity;

public class DoubleNode {
    public int val;
    public int key;
    public DoubleNode next;
    public DoubleNode pre;

    public DoubleNode(int val) {
        this.val = val;
    }

    public DoubleNode(int key, int val) {
        this(val);
        this.key = key;
    }
}
