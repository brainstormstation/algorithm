package com.enterprise.facebook.lintcode;

/**
 * Description
 * Given a string, determine if it is a palindrome, 
 * considering only alphanumeric characters and ignoring cases.
 */
public class Code415_ValidPalindrome {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        int start = 0;
        int end = s.length()-1;
        while (start < end) {
            while (start < end && !isValid(s.charAt(start))) {
                start++;
            }
            while (start < end && !isValid(s.charAt(end))) {
                end--;
            }
            if (start < end && !isEqual(s.charAt(start), s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isValid(Character c) {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }

    private boolean isEqual(Character c1, Character c2) {
        return Character.toLowerCase(c1) == Character.toLowerCase(c2);
    }
}
