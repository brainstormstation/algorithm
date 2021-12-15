package com.enterprise.facebook.lintcode;

import java.util.*;

public class Code425_LetterCombinationsOfAPhoneNumber {
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

    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        // write your code here
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }

        List<String> result = new ArrayList<>();
        process(digits, 0, new StringBuilder(), result);
        return result;
    } 

    private void process(String digits, int index,StringBuilder str, List<String> result) {
        if (index == digits.length()) {
            result.add(str.toString());
            return;
        }

        int num = digits.charAt(index) - '0';
        for (char c : letters[num-1].toCharArray()) {
            str.append(c);
            process(digits, index+1, str, result);
        }
    }
    
}
