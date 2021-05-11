package com.twopointers;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class SortColorsTest {
    private SortColors target;

    @Before
    public void setup() {
        this.target = new SortColors();
    }

    @Test
    public void testSortColors() {
        int[] arr = new int[] {1, 0, 1, 2};
        this.target.sortColors(arr);
        assertArrayEquals(new int[] {0, 1, 1, 2}, arr);
    }
    
}
