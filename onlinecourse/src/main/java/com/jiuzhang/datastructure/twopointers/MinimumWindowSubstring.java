package com.lintcode.datastructure.twopointers;

/**
 * <b>Description</b>
 * <p>
 * Given two strings s and t of lengths m and n respectively, 
 * return the minimum window in s which will contain all the characters in t. 
 * If there is no such window in s that covers all characters in t, return the empty string "".
 * <p>
 * <b>Note</b> that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.
 * <p>
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] tChars = new int[128];
        for (char c: t.toCharArray()) {
            tChars[c]++;
        }
        
        int tlen = t.length();
        
        int start = 0;
        int window = 0;
        int min = Integer.MAX_VALUE;
        String result = "";
        
        for (int end = 0; end < s.length(); end++) {
            if (tChars[s.charAt(end)] > 0) {
                window++;
            }
            tChars[s.charAt(end)]--;
            
            while (window == tlen) {
                if (min > end - start + 1) {
                    min = end - start + 1;
                    result = s.substring(start, end + 1);
                }
                
                tChars[s.charAt(start)]++;
                if (tChars[s.charAt(start)] > 0) {
                    window--;
                }
                start++;
            }
        }
        
        return result;
    }
    
}
