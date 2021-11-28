package com.jiuzhang.datastructure.memorysearch;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RegularExpressionMatchingTest {
    private RegularExpressionMatching target;

    @Before
    public void setup() {
        this.target = new RegularExpressionMatching();
    }

    @Test
    public void testIsMatch() {
        String s = "aab";
        String p = "c*a*b";
        boolean result = this.target.isMatch(s, p);
        assertTrue(result);
    }
}
