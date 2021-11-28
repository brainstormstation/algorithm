package com.enterprise.facebook;

import java.util.*;

public class Code227_BasicCalculatorII {
    public int calculate(String s) {
        int curNumber = 0;
        char curOper = '+';
        Stack<Integer> numbers = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                curNumber = (curNumber * 10) + (curr - '0');
            }

            if (!Character.isDigit(curr) && !Character.isWhitespace(curr) || i == s.length() - 1) {
                if(curOper == '+') {
                    numbers.push(curNumber);
                } else if (curOper == '-'){
                    numbers.push(-curNumber);
                } else if (curOper == '*') {
                    numbers.push(numbers.pop() * curNumber);
                } else if (curOper == '/') {
                    numbers.push(numbers.pop() / curNumber); 
                }
                curOper = curr;
                curNumber = 0;
            }
        }
        

        int result = 0;
        while (!numbers.isEmpty()) {
            result += (int)numbers.pop();
        }
        return result;
    }
}
