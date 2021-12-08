package com.enterprise.facebook.leetcode;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * The testcases will be generated such that the answer is unique.
 * A substring is a contiguous sequence of characters within the string.
 */
public class Code76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] chars = new int[128];
        for (char c: t.toCharArray()) {
            chars[c]++;
        }

        int len = Integer.MAX_VALUE;
        String result = "";
        int start = 0;
        int window = 0;
        for (int end = 0; end < s.length(); end++) {
            if (chars[s.charAt(end)]>0) {
                window++;
            }            
            chars[s.charAt(end)]--;
            while (window == t.length()) {
                int dis = end - start + 1;
                if (dis<len) {
                    len = dis;
                    result = s.substring(start, end+1);
                }
                chars[s.charAt(start)]++;
                if (chars[s.charAt(start)]>0) {
                    window--;
                }
                start++;
            }

        }
        return result;
    }
    
}
