package com.enterprise.facebook.lintcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Code17_SubsetsTest {
    private Code17_Subsets target;

    @Before
    public void setup() {
        this.target = new Code17_Subsets();
    }

    @Test
    public void testSubsets() {
        int[] input = new int[]{1,2,3};
        List<List<Integer>> actual = this.target.subsets(input);
        int[][] expected = new int[][]{{},{1},{1,2},{2}};
        assertArrayEquals(expected, actual.toArray());
    }
    
}
