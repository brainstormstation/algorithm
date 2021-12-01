package com.enterprise.facebook.leetcode;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class Code973_KClosestPointsToOriginTest {
    private Code973_KClosestPointsToOrigin target;

    @Before
    public void setup() {
        this.target = new Code973_KClosestPointsToOrigin();
    }

    @Test
    public void testkClosest() {
        int k =1;
        int[][] tc = new int[][] {{1,3},{-2,2}};
        int[][] actuals = this.target.kClosest(tc, k);
        int[][] expecteds = new int[][] {{-2, 2}};
        assertArrayEquals(expecteds, actuals);
    }
    
}
