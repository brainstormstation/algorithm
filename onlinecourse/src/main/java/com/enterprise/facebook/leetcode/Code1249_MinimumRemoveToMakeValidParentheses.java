package com.enterprise.facebook.leetcode;

import java.util.*;
/**
 * Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 */
public class Code1249_MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> remove = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    remove.add(i);
                }
                else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            remove.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j<s.length(); j++) {
            if (remove.contains(j)) {
                continue;
            }
            sb.append(s.charAt(j));
        }
        return sb.toString();

    }

}