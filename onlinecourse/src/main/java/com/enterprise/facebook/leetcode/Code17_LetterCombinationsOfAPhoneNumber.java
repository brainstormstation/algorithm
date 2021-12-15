package com.enterprise.facebook.leetcode;

import java.util.*;

/**
 * Given a string containing digits from 2-9 inclusive, 
 * return all possible letter combinations that the number could represent. 
 * Return the answer in any order.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. 
 * Note that 1 does not map to any letters.
 */
public class Code17_LetterCombinationsOfAPhoneNumber {
    private String[] letters = {
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length()==0) {
            return new ArrayList<String>();
        }

        List<String> result = new ArrayList<>();
        process(digits, 0, "", result);
        return result;
    }

    private void process(String digits, int index, String curr, List<String> result) {
        if (index == digits.length()) {
            result.add(curr);
            return;
        }

        int num = digits.charAt(index) - '0';
        for (char c : letters[num-1].toCharArray()) {
            process(digits, index+1, curr+c, result);
        }
    }
}
