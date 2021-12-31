package com.enterprise.facebook.lintcode;

import java.util.*;

/**
 * Description
 * Given a set of candidate numbers candidates and a target number target. 
 * Find all unique combinations in candidates where the numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 */
public class Code135_CombinationSum {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        Arrays.sort(candidates);
        int[] arr = removeDuplicates(candidates);
        backtrace(target, 0, comb, arr, result);
        return result;
    }

    private int[] removeDuplicates(int[] candidiates) {
        if (candidiates.length < 2) {
            return candidiates;
        }
        int start = 0;
        int end = 1;
        while (end < candidiates.length) {
            if (candidiates[start] == candidiates[end]) {
                end++;
            }
            else {
                candidiates[start+1] = candidiates[end];
                start++;
            }
        }
        int[] result = new int[start+1];
        System.arraycopy(candidiates, 0, result,0, start+1);
        return result;
    }

    private void backtrace(int remain, int start, LinkedList<Integer> combin, int[] candidates, List<List<Integer>> result) {
        if(remain == 0) {
            result.add(new ArrayList<>(combin));
            return;
        }

        if (remain < 0) {
            return;
        }

        for (int i=start; i<candidates.length; i++) {
            combin.add(candidates[i]);
            backtrace(remain - candidates[i], i, combin, candidates, result);
            combin.removeLast();
        }
    }
}
