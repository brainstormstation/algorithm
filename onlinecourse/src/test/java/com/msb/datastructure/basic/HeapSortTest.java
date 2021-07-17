package com.msb.datastructure.basic;

import com.testutil.TestUtil;

import org.junit.Before;
import org.junit.Test;

public class HeapSortTest {
    private HeapSort target;

    @Before
    public void setup() {
        this.target = new HeapSort();
    }

    @Test
    public void testHeapSort() {
        int[] arr = TestUtil.generateRandomArray(10, 100);
        target.sort(arr);
    }
    
}
