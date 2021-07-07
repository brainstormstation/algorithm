package com.leetcode.datastructure;

import java.util.HashSet;

/**
 * <b>Description</b>
 * <p>
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }
        HashSet<Character> set = new HashSet<>();
        int j = 0;
        int maxLen = 0;
        for (int i = 0; i<s.length(); i++) {
            while (j<s.length() && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
            }
            maxLen = Math.max(maxLen, j - i);
            set.remove(s.charAt(i));
        }
        return maxLen;
    }
}
