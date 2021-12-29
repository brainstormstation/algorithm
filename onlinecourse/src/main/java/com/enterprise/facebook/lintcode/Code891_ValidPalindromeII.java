package com.enterprise.facebook.lintcode;

/**
 * Description
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 */
public class Code891_ValidPalindromeII {
    /**
     * @param s: a string
     * @return: whether you can make s a palindrome by deleting at most one character
     */
    public boolean validPalindrome(String s) {
        return isValid(s, 0, s.length()-1, 0);
    }

    private boolean isValid(String str, int start, int end, int count) {
        if (str == null || str.length() ==1) {
            return true;
        }

        if (count >1) {
            return false;
        }

        while (start<=end) {
            if (str.charAt(start) != str.charAt(end)) {
                return isValid(str, start, end-1, count+1) || isValid(str, start+1, end, count+1);
            }
            start++;
            end--;
        }
        return true;
    }
}
 