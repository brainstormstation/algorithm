package com.msb.datastructure.basic;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class HanoiTest {
    private Hanoi target;

    @Before
    public void setup() {
        this.target = new Hanoi();
    }

    @Test
    public void testHanoi1() {
        target.leftToRight(4);
        assertTrue(true);
    }
}
