package com.datastructure.memorysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <b>Description</b>
 * <p>
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * <p>
 * https://www.jiuzhang.com/problem/word-break-ii/
 */
public class WordBreakII {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public ArrayList<String> wordBreak(String s, Set<String> wordDict) {
        if (wordDict.size() == 0) {
            return new ArrayList<String>();
        }
        // write your code here
        Map<String, ArrayList<String>> memo = new HashMap<>();
        return wordBreakHelper(s, wordDict, memo);
    }

    private ArrayList<String> wordBreakHelper(String s, Set<String> dict, Map<String, ArrayList<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        ArrayList<String> results = new ArrayList<String>();
        
        if (s.length() == 0) {
            return results;
        }
        
        if (dict.contains(s)) {
            results.add(s);
        }
        
        for (int len = 1; len < s.length(); ++len){
            String word = s.substring(0, len);
            if (!dict.contains(word)) {
                continue;
            }
            
            String suffix = s.substring(len);
            ArrayList<String> segmentations = wordBreakHelper(suffix, dict, memo);
            
            for (String segmentation: segmentations){
                results.add(word + " " + segmentation);
            }
        }
        
        memo.put(s, results);
        return results;
    }
}
