package com.msb.datastructure.basic;

import static org.junit.Assert.assertEquals;

import java.beans.BeanProperty;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class ReverseStackTest {
    private ReverseStack target;

    @Before
    public void setup() {
        this.target = new ReverseStack();
    }

    @Test
    public void testReverseStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        target.reverse(stack);
        int a = stack.pop();
        assertEquals(1, a);
        a = stack.pop();
        assertEquals(2, a);
        a = stack.pop();
        assertEquals(3, a);
        a = stack.pop();
        assertEquals(4, a);

    }
    
}
