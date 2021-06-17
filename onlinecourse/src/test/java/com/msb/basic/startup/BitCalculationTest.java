package com.msb.basic.startup;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BitCalculationTest {
    private BitCalculation target;

    @Before
    public void setup() {
        this.target = new BitCalculation();
    }

    @Test
    public void testAdd() {
        int a = (int)Math.random();
        int b = (int)Math.random();
        int expected = a + b;
        int result = this.target.add(a, b);
        assertEquals(expected, result);
    }

    @Test
    public void testMinus() {
        int a = (int)Math.random();
        int b = (int)Math.random();
        int expected = a - b;
        int result = this.target.minus(a, b);
        assertEquals(expected, result);
    }

    @Test
    public void testMulti() {
        int a = (int)Math.random();
        int b = (int)Math.random();
        int expected = a * b;
        int result = this.target.multi(a, b);
        assertEquals(expected, result);
    }

    @Test
    public void testMultiWithNegNumber() {
        int a = (int)Math.random();
        int b = -(int)Math.random();
        int expected = a * b;
        int result = this.target.multi(a, b);
        assertEquals(expected, result);
    }
}
