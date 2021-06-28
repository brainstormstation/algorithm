package com.lintcode.datastructure.twopointers;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class QuickSortTemplateTest {
    private QuickSortTemplate target;

    @Before
    public void setup() {
        this.target = new QuickSortTemplate();
    }

    @Test
    public void testQuickSort() {
        int[] arr = new int[] {23, 33, 91, 10, 21,14,29,38,10};

        int[] expected = new int[] {10, 10, 14, 21, 23, 29, 33, 38, 91};

        this.target.quickSort(arr);

        assertArrayEquals(expected, arr);
    }
    
}
