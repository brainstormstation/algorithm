package com.msb.datastructure.startup;

import static org.junit.Assert.assertArrayEquals;

import com.testutil.TestUtil;

import org.junit.Before;
import org.junit.Test;

public class SelectSortTest {
    private SelectSort target;

    @Before
    public void setup() {
        this.target = new SelectSort();
    }

    @Test
    public void testSelectSort() {
        int[] arr = new int[] {2,4,1,5,20,12,53,4,8};
        this.target.selectSort(arr);
        TestUtil.printArr(arr);
        int[] expect = new int[] {1, 2, 4, 4, 5, 8, 12, 20, 53};
        assertArrayEquals(expect, arr);
    }
    
}
