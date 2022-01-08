package com.enterprise.facebook.lintcode;

import java.util.*;

/**
 * Description
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end.
 * Transformation rule such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 */
public class Code120_WordLadderII {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public int findLadders(String start, String end, Set<String> dict) {
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
        queue.add(start);
        set.add(start);
        int len = 1;
        while (!queue.isEmpty()) {
            len++;
            int size = queue.size();
            for (int i=0; i<size; i++) {
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
        for (char c = 'a'; c<'z'; c++) {
            for (int i=0; i<word.length(); i++) {
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
