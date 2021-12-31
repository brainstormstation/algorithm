package com.enterprise.facebook.lintcode;

import java.util.*;

/**
 * Description
 * Given an array num and a number target. Find all unique combinations in num where the numbers sum to target.
 * <ul>
 * <li>Each number in num can only be used once in one combination.</li>
 * <li>All numbers (including target) will be positive integers.</li>
 * <li>Numbers in a combination a1, a2, … , ak must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak)</li>
 * <li>Different combinations can be in any order.</li>
 * <li>The solution set must not contain duplicate combinations.</li>
 * </ul>
 */
public class Code153_CombinationSumII {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        Arrays.sort(candidates);
        backtrace(target, 0, candidates, comb, result);
        return result;
    }
    
    private void backtrace(int remain, int start, int[] candidates, LinkedList<Integer> comb, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }
        
        for (int i=start; i<candidates.length; ++i) {
            if (i>start && candidates[i] == candidates[i-1]) {
                continue;
            }
            
            int cur = candidates[i];
            
            if (remain - cur<0) {
                break;
            }
            
            comb.add(cur);
            backtrace(remain - cur, i+1, candidates, comb, result);
            comb.removeLast();
        }
    }
}
