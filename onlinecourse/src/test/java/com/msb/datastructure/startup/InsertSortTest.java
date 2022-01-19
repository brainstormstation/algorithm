package com.msb.datastructure.startup;

import static org.junit.Assert.assertArrayEquals;

import com.testutil.TestUtil;

import org.junit.Before;
import org.junit.Test;

public class InsertSortTest {
    private InsertSort target;

    @Before
    public void setup() {
        this.target = new InsertSort();
    }

    @Test
    public void testInsertSort() {
        int[] arr = new int[] {23, 2, 3, 10, 29, 0, 4, 38};
        this.target.insertSort(arr);
        TestUtil.printArr(arr);
        int[] expect = new int[] {0, 2, 3, 4, 10, 23, 29, 38};
        assertArrayEquals(expect, arr);
    }

    @Test
    public void testInsertSort2() {
        int[] arr = new int[] {23, 2, 3, 10, 29, 0, 4, 38};
        this.target.insertSort2(arr);
        TestUtil.printArr(arr);
        int[] expect = new int[] {0, 2, 3, 4, 10, 23, 29, 38};
        assertArrayEquals(expect, arr);
    }
}
