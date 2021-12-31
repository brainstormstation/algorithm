package com.enterprise.facebook.lintcode;

import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class Code135_CombinationSumTest {
    private Code135_CombinationSum target;

    @Before
    public void setup() {
        this.target = new Code135_CombinationSum();
    }

    @Test
    public void testCombinationSum() {
        int[] input = new int[] {2, 2, 3};
        int target = 7;
        List<List<Integer>> result = this.target.combinationSum(input, target);
        assertTrue(true);
    }
}
