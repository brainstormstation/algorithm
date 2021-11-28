package com.jiuzhang.datastructure.twopointers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TwoSumUniquePairsTest {

    private TwoSumUniquePairs target;

    @Before
    public void setup() {
        this.target = new TwoSumUniquePairs();
    }

    @Test
    public void testTwoSum6() {
        int[] arr = new int[] {1,1,2,45,46,46};
        int sum = 47;
        int count = this.target.twoSum6(arr, sum);
        assertEquals(2, count);
    }
    
}
