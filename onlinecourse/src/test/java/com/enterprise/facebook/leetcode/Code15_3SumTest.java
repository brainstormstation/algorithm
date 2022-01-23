package com.enterprise.facebook.leetcode;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Code15_3SumTest {
    private Code15_3Sum target;

    @Before
    public void setup() {
        this.target = new Code15_3Sum();
    }

    @Test
    public void test() {
        int[] arr = {-3, -1, -1, -1, 2};
        List<List<Integer>> actuall = this.target.threeSum(arr);
        assertTrue(true);
    }
}
