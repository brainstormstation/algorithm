package com.datastructure.memorysearch;

/**
 * <b>Description</b>
 * <p>
 * Implement wildcard pattern matching with support for '?' and '*'.
 * The matching rules are as follows：
 * <p>
 * '?' Matches any single character.
 * <p>
 * '*' Matches any sequence of characters (including the empty sequence).
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * https://www.lintcode.com/problem/192/?_from=ladder&fromId=161
 * <p>
 * <b>Solution</b>
 * <p>
 * 使用深度优先搜索 + 记忆化的版本。
 * 用一个二维的 boolean 数组来当记忆化数组，记录 s 从 sIndex 开始的后缀 能够匹配上 p 从 pIndex 开始的后缀
 */
public class WildcardMatching {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if (s == null || p == null) {
            return false;
        }

        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];

        return isMatchHelper(s, 0, p, 0, memo, visited);
    }

    private boolean isMatchHelper(String s, int sIndex,
                                  String p, int pIndex,
                                  boolean[][] memo,
                                  boolean[][] visited) {
        if (pIndex == p.length()) {
            return sIndex == s.length();
        }

        if (sIndex == s.length()) {
            return allStar(p, pIndex);
        }

        if (visited[sIndex][pIndex]) {
            return memo[sIndex][pIndex];
        }
        
        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);
        boolean match;

        if (pChar == '*') {
            match = isMatchHelper(s, sIndex, p, pIndex+1, memo, visited) ||
            isMatchHelper(s, sIndex+1, p, pIndex, memo, visited);
        } else {
            match = charMatch(sChar, pChar) &&
            isMatchHelper(s, sIndex+1, p, pIndex+1, memo, visited);
        }

        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;
        return match;
    }

    private boolean charMatch(char sChar, char pChar) {
        return (sChar == pChar || pChar == '?'); 
    }

    private boolean allStar(String p, int pIndex) {
        for (int i=pIndex; i<p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
}

