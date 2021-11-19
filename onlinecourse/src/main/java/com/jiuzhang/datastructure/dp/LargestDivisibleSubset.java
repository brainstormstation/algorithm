package com.lintcode.datastructure.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * <b>Description</b>
 * <p>
 * Given a set of distinct positive integers, find the largest subset which has the most elements, 
 * and every pair of two elements (Si, Sj) in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 * <p>
 * https://www.lintcode.com/problem/603/?_from=collection&fromId=161
 */
public class LargestDivisibleSubset {
    /**
     * @param nums: a set of distinct positive integers
     * @return: the largest subset 
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // write your code here
        if ( nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        int n = nums.length;
        HashMap<Integer, Integer> dp = new HashMap<>();
        HashMap<Integer, Integer> prev = new HashMap<>();

        for (int i=0; i< n ; i++) {
            dp.put(nums[i], 1);
            prev.put(nums[i], -1);
        }

        int lastNum = nums[0];
        for (int i=0; i<n; i++) {
            int num = nums[i];
            for (Integer factor: getFactors(num)) {
                if (!dp.containsKey(factor)) {
                    continue;
                }
                if (dp.get(num) < dp.get(factor)+1) {
                    dp.put(num, dp.get(factor) + 1);
                    prev.put(num, factor);
                }
            }
            if (dp.get(num) > dp.get(lastNum)) {
                lastNum = num;
            }
        }
        return getPath(prev, lastNum);
    }

    private List<Integer> getPath(HashMap<Integer, Integer> prev, int lastNum) {
        List<Integer> path = new ArrayList<>();
        while (lastNum !=-1) {
            path.add(lastNum);
            lastNum = prev.get(lastNum);
        }
        Collections.reverse(path);
        return path;
    }

    private List<Integer> getFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        if (num ==1) {
            return factors;
        }
        int factor = 1;
        while (factor * factor <=num) {
            if (num % factor == 0) {
                factors.add(factor);
                if (factor != 1 && num/factor !=factor) {
                    factors.add(num/factor);
                }
            }
            factor++;
        }
        return factors;
    }

}
