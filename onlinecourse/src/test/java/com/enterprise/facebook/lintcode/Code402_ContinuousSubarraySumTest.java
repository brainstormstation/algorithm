package com.enterprise.facebook.lintcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Code402_ContinuousSubarraySumTest {
    private Code402_ContinuousSubarraySum target;

    @Before
    public void setup() {
        this.target = new Code402_ContinuousSubarraySum();
    }

    @Test
    public void testMtehod() {
        int[] arr = {-3,1,3,-3,4,-2,1};
        List<Integer> actual = this.target.continuousSubarraySum(arr);
        List<Integer> expected = Arrays.asList(1,4);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
