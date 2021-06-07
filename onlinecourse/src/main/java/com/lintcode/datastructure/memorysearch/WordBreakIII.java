package com.lintcode.datastructure.memorysearch;

import java.util.HashSet;
import java.util.Set;

/**
 * <b>Description</b>
 * <p>
 * Give a dictionary of words and a sentence with all whitespace removed, 
 * return the number of sentences you can form by inserting whitespaces to the sentence so that each word can be found in the dictionary.
 * <p>
 * https://www.lintcode.com/problem/683/?_from=ladder&fromId=161
 */
public class WordBreakIII {
    /**
     * @param s: A string
     * @param dict: A set of word
     * @return: the number of possible sentences.
     */
    public int wordBreak3(String s, Set<String> dict) {
        // Write your code here
        int n = s.length();
        String lowerStr = s.toLowerCase();
        Set<String> lowerDic = new HashSet<>();
        for (String str: dict) {
            lowerDic.add(str.toLowerCase());
        }
        int[][] dp = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                String sub = lowerStr.substring(i, j+1);
                if (lowerDic.contains(sub)) {
                    dp[i][j] = 1;
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                for (int k=i; k<j; k++) {
                    dp[i][j] += (dp[i][k] * dp[k+1][j]);
                }
            }
        }
        return dp[0][n-1];
        
    }
}
