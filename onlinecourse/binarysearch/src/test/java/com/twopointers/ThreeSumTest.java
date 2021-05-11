package com.twopointers;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ThreeSumTest {
    private ThreeSum target;

    @Before
    public void setup() {
        this.target = new ThreeSum();
    }

    @Test
    public void testThreeSum() {
        int[] arr = new int[] {-1,0,1,2,-1,-4};
        List<List<Integer>> result = this.target.threeSum(arr);
        List<Integer> result1 = result.get(0);
        assertArrayEquals(new Integer[] {-1,-1,2}, result1.toArray(new Integer[result1.size()]));
        List<Integer> result2 = result.get(1);
        assertArrayEquals(new Integer[] {-1,0,1}, result2.toArray(new Integer[result2.size()]));
    }
}
