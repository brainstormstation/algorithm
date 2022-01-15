package com.enterprise.facebook.lintcode;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Code397_LongestContinuousIncreasingSubsequenceTest {
    private Code397_LongestContinuousIncreasingSubsequence target;

    @Before
    public void setup() {
        this.target = new Code397_LongestContinuousIncreasingSubsequence();
    }

    @Test
    public void testMethod() {
        int[] input = {99,55,7,29,80,33,19,23,6,35,40,27,44,74,5,17,52,36,67,32,37,42,18,77,66,62,97,79,60,94,30,2,85,22,26,91,3,16,8,0,48,93,39,31,63,13,71,58,69,50,21,70,61,43,12,88,47,45,72,76};
        int expected = 4;
        int actual = this.target.longestIncreasingContinuousSubsequence(input);
        assertEquals(expected, actual);
    }
}
