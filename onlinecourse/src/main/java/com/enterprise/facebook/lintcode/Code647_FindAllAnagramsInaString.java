package com.enterprise.facebook.lintcode;

import java.util.*;

public class Code647_FindAllAnagramsInaString {
    /**
     * @param s: a string
     * @param p: a string
     * @return: a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        // write your code here
        int[] arr = new int[26];
        for (char c: p.toCharArray()) {
            arr[c-'a']++;
        }
        List<Integer> result = new ArrayList<>();
        int start = 0, end = -1;
        while (start < s.length()) {
            if (end-start+1 ==  p.length()) {
                result.add(start);
            }
            if (end+1<s.length() && arr[s.charAt(end+1)-'a']>0) {
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
