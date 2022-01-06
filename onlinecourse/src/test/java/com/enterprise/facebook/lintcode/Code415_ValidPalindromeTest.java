package com.enterprise.facebook.lintcode;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Code415_ValidPalindromeTest {
    private Code415_ValidPalindrome target;

    @Before
    public void setup() {
        this.target = new Code415_ValidPalindrome();
    }

    @Test
    public void testIsPalindrome() {
        String str = "A man, a plan, a canal: Panama";
        boolean expected = true;
        boolean actual = target.isPalindrome(str);
        assertEquals(expected, actual);
    }
    
}
