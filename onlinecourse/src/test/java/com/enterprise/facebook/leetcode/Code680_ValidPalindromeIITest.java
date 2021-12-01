package com.enterprise.facebook.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Code680_ValidPalindromeIITest {
    private Code680_ValidPalindromeII target;

    @Before
    public void setup() {
        this.target = new Code680_ValidPalindromeII();
    }

    @Test
    public void testValidPalindromeII() {
        String s = "abca";
        boolean flag = this.target.validPalindrome(s);
        assertEquals(false, flag);
    }
    
}
