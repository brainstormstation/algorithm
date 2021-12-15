package com.enterprise.facebook.lintcode;

/**
 * Description
 * Implement function atoi to convert a string to an integer.
 * If no valid conversion could be performed, a zero value is returned.
 * If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class Code54_StringToIntegerATOI {
    public int atoi(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int res = 0;
        char sign = '+';
        int start = 0;
        while(start<s.length() && Character.isWhitespace(s.charAt(start))) {
            start++;
        }
        
        if (start ==  s.length()) {
            return 0;
        }
        if (s.charAt(start) == '-' || s.charAt(start)=='+') {
            sign = s.charAt(start++);
        }        

        while (start<s.length() && !Character.isDigit(s.charAt(start))) {
            int digit = s.charAt(start++)-'0';
            // Check overflow and underflow conditions. 
            if ((res > Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) { 
                // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.    
                return sign == '+' ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
        }

        if (sign == '-') {
            return -res;
        }
        return res;
    }
}
