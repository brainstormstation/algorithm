package com.msb.datastructure.system;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class EorOperationsTest {

    private EorOperations target;

    @Before
    public void setup() {
        this.target = new EorOperations();
    }

    @Test
    public void testSwap() {
        int[] a = new int[] {2,3,4,8,9,10,22};
        int i = 0, j = 4;
        target.swap(a, i, j);
        assertEquals(9, a[0]);
        assertEquals(2, a[4]);
    }

    @Test
    public void testFindOnlyOddNumber() {
        int[] a = new int[] {2,2,3,3,3,4,4,4,4,5,5};
        int result = target.findOnlyOddNumber(a);
        assertEquals(3, result);
    }

    @Test
    public void testGetRightOne() {
        int a = 168; //10101000; 8+32+128
        int expected = 8;
        int actual = target.getTheRightOne(a);
        assertEquals(expected, actual);
    }

    @Test
    public void testOnlyKtimes() {
        int[] arr = new int[] {-1, 2,2,2,3,4,3,4,3,4,-1};
        int expected = -1;
        int actual = target.onlyKtimes(arr, 2, 3);
        assertEquals(expected, actual);
    }

    
}
