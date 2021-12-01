package com.enterprise.facebook.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.lintcode.com/problem/641
 * Description
 * Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
 */
public class Code641_MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // write your code here
        List<String> ans = new ArrayList<>();
        
        for (int n: nums) {
            if (n>lower) {
                ans.add(format(lower, n, false));
            }
            if (n==upper) {
                return ans;
            }
            lower = n+1;
        }
        ans.add(format(lower, upper, true));
        return ans;
    }

    private String format(int start, int end, boolean flag) {
        String ret = ""+start;
        if (flag) {
            if (end>start) {
                ret+="->"+end;
            }
            return ret;
        }
        if (end > (start+1)) {
            ret +="->"+(end-1);
        }
        return ret;
    }
}
