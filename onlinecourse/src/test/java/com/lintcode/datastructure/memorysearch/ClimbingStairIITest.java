package com.lintcode.datastructure.memorysearch;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ClimbingStairIITest {
    private ClimbingStairsII target;

    @Before
    public void setup() {
        this.target = new ClimbingStairsII();
    }

    @Test
    public void testClimbingStairs2() {
        int n = 3;
        int result = this.target.climbStairs2(n);
        assertEquals(4, result);
    }
}
