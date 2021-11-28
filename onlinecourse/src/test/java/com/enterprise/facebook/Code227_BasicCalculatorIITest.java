package com.enterprise.facebook;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class Code227_BasicCalculatorIITest {
    private Code227_BasicCalculatorII target;

    @Before
    public void setup() {
        this.target = new Code227_BasicCalculatorII();
    }

    @Test
    public void testCalculate() {
        String expression = "3/2";
        int actual = this.target.calculate(expression);
        int expected = 1;
        assertEquals(expected, actual);
    }
    
}
