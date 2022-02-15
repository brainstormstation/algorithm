package com.enterprise.facebook.lintcode;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Code54_StringToIntegerATOITest {
    private Code54_StringToIntegerATOI target;

    @Before
    public void setup() {
        this.target = new Code54_StringToIntegerATOI();
    }

    @Test
    public void testConvert() {
        String s = "2147483646";
        int actual = this.target.atoi(s);
        int expected = 2147483646;
        assertEquals(expected, actual);
    }

    @Test
    public void test2Convert() {
        String s = " -0 ";
        int actual = this.target.atoi2(s);
        int expected = 2147483646;
        assertEquals(expected, actual);
    }
    
}
