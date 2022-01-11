package com.enterprise.facebook.lintcode;

public class Code1263_IsSubsequence {
    /**
     * @param s: the given string s
     * @param t: the given string t
     * @return: check if s is subsequence of t
     */
    public boolean isSubsequence(String s, String t) {
        // Write your code here
        int index_s = 0;
        int index_t = 0;
        while (index_t < t.length()) {
            if (index_s == s.length()) {
                return true;
            }
            if (s.charAt(index_s) == t.charAt(index_t)) {
                index_s++;
            }
            index_t++;
        }
        return index_s == s.length();
    }
}
