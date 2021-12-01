package com.enterprise.facebook;

public class Code415_AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sp = new StringBuilder();
        int carry = 0;
        int p1 = num1.length()-1;
        int p2 = num2.length()-1;

        while(p1>=0 || p2>=0) {
            int x1 = p1>=0?num1.charAt(p1--)-'0':0;
            int x2 = p2>=0?num2.charAt(p2--)-'0':0;
            int sum = x1 + x2 + carry;
            carry = sum >= 10? 1: 0;
            sp.append(sum % 10);
        }

        if (carry != 0) {
            sp.append(carry);
        }
        return sp.reverse().toString();
    }
    
}
