package com.enterprise.facebook.lintcode;

import java.util.*;

public class Code1304_HIndex {
    /**
     * @param citations: a list of integers
     * @return: return a integer
     */
    public int hIndex(int[] citations) {
        // write your code here
        Arrays.sort(citations);
        int h = 0;
        for (int i=0; i<citations.length; i++) {
            h = citations.length - i;
            if (citations[i]>h) {
                return h;
            }
        }
        return -1;
    }
}
