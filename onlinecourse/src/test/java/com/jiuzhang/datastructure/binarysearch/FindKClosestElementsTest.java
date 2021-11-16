package com.lintcode.datastructure.binarysearch;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class FindKClosestElementsTest {

    private FindKClosestElements target;

    @Before
    public void setup() {
        this.target = new FindKClosestElements();
    }


    @Test
    public void testKClosestNumbers() {
        int[] nums = {2, 5, 10, 200, 201, 220, 400};
        int target = 200;
        int k = 5;
        int[] result = this.target.kClosestNumbers(nums, target, k);
        int[] expect = new int[] {200, 201, 220, 10, 5};
        assertEquals(k, result.length);
        assertArrayEquals(expect, result);
    }
    
}
