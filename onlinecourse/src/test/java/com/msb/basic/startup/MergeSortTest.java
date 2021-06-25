package com.msb.basic.startup;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {
    private MergeSort target;
    @Before
    public void setup() {
        this.target = new MergeSort();
    }

    @Test
    public void testMergeSort() {
        int[] a = new int[] { 47,29,60,28,43,38,63,87,20,1,4,4};
        target.mergeSort(a);
        int[] expected = new int[] {1,4,4,20,28,29,38,43,47,60,63,87};
        Assert.assertArrayEquals(expected, a);
    }
    
}
