package com.jiuzhang.datastructure.twopointers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MinimumWindowSubstringTest {
    private MinimumWindowSubstring target;

    @Before
    public void setup() {
        this.target = new MinimumWindowSubstring();
    }

    @Test
    public void testMinWindow() {
        String s = "ADOBECODEBANC", t = "ABC";
        String result = this.target.minWindow(s, t);
        assertEquals("BANC", result);
    }

    @Test
    public void testMinWindowWithDuplicate() {
        String s = "AA", t = "AA";
        String result = this.target.minWindow(s, t);
        System.out.println(result);
        assertEquals("AA", result);
    }
    
    @Test
    public void testMinWindow1() {
        String s = "a", t = "ab";
        String result = this.target.minWindow(s, t);
        System.out.println(result);
        assertEquals("", result);
    }

    @Test
    public void testMinWindow2() {
        String s = "bba", t = "ab";
        String result = this.target.minWindow(s, t);
        assertEquals("ba", result);
    }
}
