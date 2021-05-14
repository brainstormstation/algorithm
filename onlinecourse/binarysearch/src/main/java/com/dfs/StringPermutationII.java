package com.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <b>Description</b>
 * <p>
 * Given a string, find all permutations of it without duplicates.
 * <p>
 * https://www.lintcode.com/problem/10/?_from=ladder&fromId=161
 */
public class StringPermutationII {
    /**
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> result = new ArrayList<>();
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        result.add(String.valueOf(chars));
        while ((chars = nextPermutation(chars))!=null) {
            result.add(String.valueOf(chars));
        }
        return result;
    }

    private char[] nextPermutation(char[] chars) {
        int index = -1;
        for (int i= chars.length-1; i>0; i--) {
            if (chars[i] > chars[i-1]) {
                index = i-1;
                break;
            }
        }
        if (index == -1) {
            return null;
        }
        for (int i=chars.length-1; i>index; i--) {
            if (chars[i] > chars[index]) {
                char tmp = chars[i];
                chars[i] = chars[index];
                chars[index] = tmp;
                break;
            }
        }
        reverse(chars, index+1, chars.length-1);
        return chars;
    }

    private void reverse(char[] chars, int start, int end) {
        for (int i=start, j=end; i < j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }
}
