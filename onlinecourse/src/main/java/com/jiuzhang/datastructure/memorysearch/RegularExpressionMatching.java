package com.jiuzhang.datastructure.memorysearch;
/**
 * <b>Description</b>
 * <p>
 * The implementation supports regular expression matching for '.' and '*'. '.' matches any single character. 
 * '*' matches zero or more of the preceding elements, before '*' is guaranteed to be a non-'*' element. 
 * The match should cover the entire input string, not just a part of it. 
 * The function that needs to be implemented is:bool isMatch(string s, string p)
 * <p>
 * https://www.lintcode.com/problem/154/?_from=ladder&fromId=161
 * <p>
 * <b>Solution</b>
 * <ul>
 * <li>采用数组memo记录各处字符匹配情况，dfs递归进行搜索，记忆化剪枝</li>
 * <li>当前p串中有 ，就有两种选择，然后 可以不去匹配，直接用p串的下一个匹配当前s串字符，或者重复p串的上一个字符匹配。</li>
 * <li>可以匹配任意字符</li>
 * </ul>
 */
public class RegularExpressionMatching {
     /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
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
        if (pIndex == p.length()) { //如果p已经匹配完毕
            return sIndex == s.length(); //根据s是否匹配完毕即可
        }

        if (sIndex == s.length()) { // 如果s匹配完毕
            return isEmpty(p, pIndex);
        }

        if (visited[sIndex][pIndex]) {
            return memo[sIndex][pIndex];
        }
        
        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);
        boolean match;

        if (pIndex + 1 < p.length() && p.charAt(pIndex+1) == '*') {
            //'*'，有两种方案
            match = isMatchHelper(s, sIndex, p, pIndex+2, memo, visited) || //'*'不去匹配字符
            charMatch(sChar, pChar) && isMatchHelper(s, sIndex+1, p, pIndex, memo, visited); //'*'重复前面一个字符去匹配s

        } else {
            match = charMatch(sChar, pChar) && //如果当前两字符匹配
            isMatchHelper(s, sIndex+1, p, pIndex+1, memo, visited); //继续下一个字符匹配
        }

        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;
        return match;
    }

    private boolean charMatch(char sChar, char pChar) {
        return sChar == pChar || pChar == '.';
    }

    private boolean isEmpty(String p, int pIndex) {
        for (int i=pIndex; i<p.length(); i+=2) {
            if (i+1 >= p.length() || p.charAt(i+1) != '*') {
                return false;
            }
        }
        return true;
    }
}
