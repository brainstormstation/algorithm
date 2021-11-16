package com.msb.datastructure.system;

import java.util.*;

public class MinStack {
    Stack<Integer> data;
    Stack<Integer> min;
    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int value) {
        data.push(value);
        if (min.isEmpty()) {
            min.push(value);
        }
        else {
            min.push(Math.min(min.peek(), value));
        }
    }

    public int pop() {
        int val = data.pop();
        min.pop();
        return val;
    }

    public int getMin() {
        return min.peek();
    }
}
