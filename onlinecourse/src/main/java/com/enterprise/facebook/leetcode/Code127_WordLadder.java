package com.enterprise.facebook.leetcode;

import java.util.*;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 * <ul>
 * <li>Every adjacent pair of words differs by a single letter.</li>
 * <Li>Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.</li>
 * <li>sk == endWord</li>
 * </ul>
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 */
public class Code127_WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null) {
            return 0;
        }

        if (beginWord == endWord) {
            return 1;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(beginWord);
        set.add(beginWord);
        int len = 1;
        while (!queue.isEmpty()) {
            len++;
            int size = queue.size();
            for (int i=0; i<size; i++) {
                String word = queue.poll();
                for (String next: getNextWord(word, wordList)) {
                    if (set.contains(next)) {
                        continue;
                    }

                    if (next.equals(endWord)) {
                        return len;
                    }
                    queue.offer(next);
                    set.add(next);
                }
            }
        }
        return 0;

    }

    private List<String> getNextWord(String word, List<String> dict) {
        ArrayList<String> words = new ArrayList<>();
        for (char c='a'; c<'z'; c++) {
            for (int i=0; i<word.length(); i++) {
                String next = replace(word, i, c);
                if (dict.contains(next)) {
                    words.add(next);
                }
            }
        }
        return words;
    }

    private String replace(String word, int index, char c) {
        char[] chars = word.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    
}
