package com.dfs;

import java.util.HashMap;

/**
 * <b>Description</b>
 * <p>
 * Given a digit string excluded 0 and 1, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * <p>
 * 1; 2: ABC; 3: DEF; <p>
 * 4: GHI; 5: JKL; 6:MNO;<p>
 * 7: PQRS; 8: TUV; 9:WXYZ;<p>
 * <p>
 * https://www.lintcode.com/problem/425/?_from=ladder&fromId=161
 */
public class LetterCombinationsOfAPhoneNumber {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        // write your code here
        HashMap<Integer, String> phone = new HashMap<>();
        phone.put(1, "");
        phone.put(2, "abc");
        phone.put(3, "def");
        phone.put(4, "ghi");
        phone.put(5, "jkl");
        phone.put(6, "mno");
        phone.put(7, "pqrs");
        phone.put(8, "tuv");
        phone.put(9, "wxyz");

        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        dfs(0, "", digits, phone, result);
        return result;
    }

    private void dfs(int index, String curr, String digits, HashMap<Integer, String> phone, List<String> result) {
        if (index == digits.length()) {
            result.add(curr);
            return;
        }

        int d = digits.charAt(index) - '0';
        for (char c: phone.get(d).toCharArray()) {
            dfs(index+1, curr+c, digits, phone, result);
        }
    }
}
