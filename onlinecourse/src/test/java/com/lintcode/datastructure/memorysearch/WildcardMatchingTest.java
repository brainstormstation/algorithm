package com.datastructure.memorysearch;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class WildcardMatchingTest {

    private WildcardMatching target;

    @Before
    public void setup() {
        this.target = new WildcardMatching();
    }

    @Test
    public void testIsMatch() {
        String s = "abscstet";
        String t = "ab*";
        boolean result = this.target.isMatch(s, t);
        assertTrue(result);
    }
    
}
