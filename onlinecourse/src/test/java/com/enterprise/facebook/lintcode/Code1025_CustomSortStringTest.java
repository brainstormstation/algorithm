package com.enterprise.facebook.lintcode;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Code1025_CustomSortStringTest {
    private Code1025_CustomSortString target;

    @Before
    public void setup() {
        this.target = new Code1025_CustomSortString();
    }

    @Test
    public void testCustomerSort() {
        String S = "cba";
        String T = "aabcd";
        String expected = "cbaad";
        String actual = this.target.customSortString(S, T);
        assertEquals(expected, actual);
    }
    
}
