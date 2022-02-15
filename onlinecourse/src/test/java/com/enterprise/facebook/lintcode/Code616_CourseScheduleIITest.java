package com.enterprise.facebook.lintcode;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class Code616_CourseScheduleIITest {
    private Code616_CourseScheduleII target;

    @Before
    public void setup() {
        this.target = new Code616_CourseScheduleII();
    }

    @Test
    public void test() {
        int[][] input = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        int n = 4;
        int[] result = this.target.findOrder(n, input);
        int[] expecteds = new int[] {0,1,2,3};
        assertArrayEquals(expecteds, result);
    }
}
