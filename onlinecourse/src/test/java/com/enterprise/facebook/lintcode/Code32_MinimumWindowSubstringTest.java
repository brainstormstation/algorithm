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

    @Test
    public void testMinWindow2() {
        String source = "abcde";
        String target = "bd";
        String actual = this.testMethod(source, target);
        String expected = "bcd";
        assertEquals(expected, actual);
    }

    private String testMethod(String source, String target) {
        // write your code here
        int start = 0;
        int end = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE, minStart=0, minEnd=0;
        int[] chars = new int[26];
        for (char c: target.toCharArray()) {
            chars[c-'a']++;
        }
        while (start < source.length()) {
            while (end<source.length() && count<target.length()) {
                if (chars[source.charAt(end)-'a']>0) {
                    count++;
                }
                chars[source.charAt(end)-'a']--;
                end++;
            }
            if (count < target.length()) {
                break;
            }
            if (end-start+1 < minLen) {
                minStart = start;
                minEnd = end;
            }
            minLen = Math.min(end-start+1, minLen);
            while (start<end && count == target.length()) {
                chars[source.charAt(start)-'a']++;
                if (chars[source.charAt(start)-'a']>0) {
                    count--;
                }
                start++;
            }

        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return source.substring(minStart, minEnd);
    }
    
}
