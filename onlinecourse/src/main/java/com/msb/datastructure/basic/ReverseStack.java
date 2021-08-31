package com.msb.datastructure.basic;

import java.util.Stack;

public class ReverseStack {
    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int last = popLast(stack);
        reverse(stack);
        stack.push(last);
    }

    private int popLast(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = popLast(stack);
            stack.push(result);
            return last;
        }
    }
}
