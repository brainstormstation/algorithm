package com.enterprise.facebook.leetcode;

import java.util.*;

public class Code140_WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        breakWord(s, result, wordDict, 0, "");
        return result;
    }

    private void breakWord(String s, List<String> result, List<String> wordDict, int start, String str) {
        if (start == s.length()) {
            result.add(str.trim());
            return;
        }

        for (int i=start+1; i<=s.length(); i++) {
            String sub = s.substring(start, i);
            if (wordDict.contains(sub)) {
                breakWord(s, result, wordDict, i, str+sub+" ");
            }
        }
    }
}
