package com.enterprise.facebook.lintcode;

import java.util.*;

public class Code12_MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public Code12_MinStack() {
        // do intialization if necessary
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        stack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);
        } else {
            int min = minStack.peek();
            minStack.push(Math.min(min, number));
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int cur = stack.pop();
        minStack.pop();
        return cur;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return minStack.peek();
    }
}
