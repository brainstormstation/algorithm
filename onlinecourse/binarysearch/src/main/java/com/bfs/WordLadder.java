package com.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * <b>Description</b>
 * <p>
 * Given two words (start and end), and a dictionary, 
 * find the shortest transformation sequence from start to end, output the length of the sequence.
 * Transformation rule such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary. 
 * (Start and end words do not need to appear in the dictionary )
 * <p>
 * <ul>
 * <li>Return 0 if there is no such transformation sequence.</li>
 * <li>All words have the same length.</li>
 * <li>All words contain only lowercase alphabetic characters.</li>
 * <li>You may assume no duplicates in the dictionary.</li>
 * <li>You may assume beginWord and endWord are non-empty and are not the same.</li>
 * <li>len(dict) <= 5000, len(start) < 5len(dict)<=5000,len(start)<5</li>
 * </ul>
 * <p>
 * https://www.lintcode.com/problem/120/?_from=ladder&fromId=161
 */
public class WordLadder {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (dict == null) {
            return 0;
        }

        if (start.equals(end)) {
            return 1;
        }

        dict.add(start);
        dict.add(end);

        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        set.add(start);
        int len = 1;

        while (!queue.isEmpty()) {
            len++;
            int size = queue.size();
            for (int i=0; i < size; i++) {
                String word = queue.poll();
                for (String next: getNextWord(word, dict)) {
                    if (set.contains(next)) {
                        continue;
                    }
                    if (next.equals(end)) {
                        return len;
                    }
                    set.add(next);
                    queue.offer(next);
                }
            }
        }
        return 0;
    }

    private List<String> getNextWord(String word, Set<String> dict) {
        List<String> words = new ArrayList<>();
        for (char c = 'a'; c < 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    words.add(nextWord);
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
