package com.enterprise.bytedance;

/**
 * <b>Description</b>
 * <p>
 * Write a method anagram(s,t) to decide if two strings are anagrams or not.
 * <p>
 * https://www.lintcode.com/problem/158/?_from=enterprise&fromId=10
 */
public class ValidAnagram {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        int cor = 0, hash = 0;
        for (char c: s.toCharArray()) {
            cor^= c;
            hash += c * c % 26;
        }

        for (char c: t.toCharArray()) {
            cor^=c;
            hash -= c* c % 26;
        }

        return cor ==0 && hash == 0;
        
    }
}
