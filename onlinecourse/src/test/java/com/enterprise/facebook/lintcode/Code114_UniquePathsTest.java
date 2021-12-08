package com.enterprise.facebook.lintcode;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Code114_UniquePathsTest {
    private Code114_UniquePaths target;

    @Before
    public void setup() {
        this.target = new Code114_UniquePaths();
    }

    @Test
    public void testUnqiuePath() {
        int m = 2, n = 62;
        int actual = this.target.uniquePaths(m, n);
        int expected = 62;
        assertEquals(expected, actual);

    }
}
