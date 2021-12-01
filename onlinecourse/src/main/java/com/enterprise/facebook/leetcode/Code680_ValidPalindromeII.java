package com.enterprise.facebook;

public class Code680_ValidPalindromeII {
    public boolean validPalindrome(String s) {
        return isValid(s.toCharArray(), 0, s.length()-1, true);
    } 

    public boolean isValid(char[] str, int start, int end, boolean flag) {
        if (start >= end) {
            return true;
        }

        if (str[start]!=str[end]) {
            if (flag == false) {
                return false;
            }
            return isValid(str, start+1, end, false) || isValid(str, start, end-1, false);

        }
        return isValid(str, start+1, end-1, flag);
    }
}
