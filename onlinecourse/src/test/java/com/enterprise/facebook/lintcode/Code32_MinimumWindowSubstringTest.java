package com.enterprise.facebook.lintcode;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Code32_MinimumWindowSubstringTest {
    private Code32_MinimumWindowSubstring target;

    @Before
    public void setup() {
        this.target = new Code32_MinimumWindowSubstring();
    }

    @Test
    public void testMinWindow() {
        String source = "abcd";
        String target = "bd";
        String actual = this.target.minWindow(source, target);
        String expected = "bcd";
        assertEquals(expected, actual);
    }
    
}
