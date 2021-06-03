package com.msb.basic.sorting;


import static org.junit.Assert.assertArrayEquals;

import com.testutil.TestUtil;

import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {
    private BubbleSort target;

    @Before
    public void setup() {
        this.target = new BubbleSort();
    }

    @Test
    public void testBubbleSort() {
        int[] arr = new int[] {2,4,1,5,20,12,53,4,8};
        this.target.bubbleSort(arr);
        TestUtil.printArr(arr);
        int[] expect = new int[] {1, 2, 4, 4, 5, 8, 12, 20, 53};
        assertArrayEquals(expect, arr);
    }
}
