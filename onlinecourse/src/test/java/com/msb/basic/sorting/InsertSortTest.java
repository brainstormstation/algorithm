package com.msb.basic.sorting;

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
    }

    @Test
    public void testInsertSort2() {
        int[] arr = new int[] {23, 2, 3, 10, 29, 0, 4, 38};
        this.target.insertSort2(arr);
        TestUtil.printArr(arr);
    }
}
