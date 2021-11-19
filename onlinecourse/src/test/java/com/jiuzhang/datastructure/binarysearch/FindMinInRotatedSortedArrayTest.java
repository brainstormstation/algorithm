package com.lintcode.datastructure.binarysearch;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class FindMinInRotatedSortedArrayTest {
    private FindMinInRotatedSortedArray target;

    @Before
    public void setup() {
        this.target = new FindMinInRotatedSortedArray();
    }
    
    @Test
    public void testFindMin() {
        int[] arr = new int[] { 4, 5, 6, 1, 2, 3};
        int pos = this.target.findMin(arr);
        assertEquals(1, pos);
    }
}
