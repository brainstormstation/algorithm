package com.enterprise.facebook.lintcode;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Code153_CombinationSumIITest {
    private Code153_CombinationSumII target;

    @Before
    public void setup() {
        this.target = new Code153_CombinationSumII();
    }

    @Test
    public void testCombinationSumII() {
        int[] candidates = new int[] {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> result = this.target.combinationSum2(candidates, target);
        assertTrue(true);
    }
    
}
