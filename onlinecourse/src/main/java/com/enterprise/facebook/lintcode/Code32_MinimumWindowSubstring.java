package com.enterprise.facebook.lintcode;

import java.util.HashMap;

/**
 * Description
 * Given two strings source and target. Return the minimum substring of source which contains each char of target.
 * If there is no answer, return "".
 * You are guaranteed that the answer is unique.
 * target may contain duplicate char, while the answer need to contain at least the same number of that char.
 * 0 <= len(source) <= 1000000<=len(source)<=100000
 * 0 <= len(target) <= 1000000<=len(target)<=100000
 */
public class Code32_MinimumWindowSubstring {

    public String minWindow(String source , String target) {
        int[] chars = new int[128];
        for (Character c : target.toCharArray()) {
            chars[c]++;
        }

        int len = Integer.MAX_VALUE;
        int window = 0;
        int start = 0;
        String result="";
        for (int end = 0; end < source.length(); end++) {
            if (chars[source.charAt(end)]>0) {
                window++;
            }
            chars[source.charAt(end)]--;
            while (window == target.length()) {
                int dis = end - start + 1;
                if (dis < len) {
                    len = dis;
                    result = source.substring(start, end+1);
                }
                chars[source.charAt(start)]++;
                if (chars[source.charAt(start)]>0) {
                    window--;
                }
                start++;
            }
        }
        return result;


    }
    
}
