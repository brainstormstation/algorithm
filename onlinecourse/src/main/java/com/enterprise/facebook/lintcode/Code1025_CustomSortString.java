package com.enterprise.facebook.lintcode;

/**
 * https://www.lintcode.com/problem/1025/
 */
public class Code1025_CustomSortString {
    /**
     * @param S: The given string S
     * @param T: The given string T
     * @return: any permutation of T (as a string) that satisfies this property
     */
    public String customSortString(String S, String T) {
        int[] count = new int[26];
        for (char c: T.toCharArray()) {
            count[c-'a']++;
        }

        StringBuilder ans = new StringBuilder();
        for (char c: S.toCharArray()) {
            for (int i=0; i<count[c-'a']; i++) {
                ans.append(c);
            }
            count[c-'a'] = 0;
        }

        for (int i =0; i<count.length; i++) {
            for (int j=0; j<count[i]; j++) {
                ans.append((char)(i+'a'));
            }
        }
        return ans.toString();
    }
}
