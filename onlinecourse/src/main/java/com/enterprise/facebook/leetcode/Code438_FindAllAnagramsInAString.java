package com.enterprise.facebook.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Code438_FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        int[] arr = new int[26];
        for (char c: p.toCharArray()) {
            arr[c-'a']++;
        }
        int start = 0, end = -1;
        List<Integer> result = new ArrayList<>();
        while (start<s.length()) {
            if (end - start + 1 == p.length()) {
                result.add(start);
            }
            if (end+1 < s.length() && arr[s.charAt(end+1)-'a']>0) {
                end++;
                arr[s.charAt(end)-'a']--;
            } else {
                arr[s.charAt(start)-'a']++;
                start++;
            }
        }
        return result;
    }
}
