package com.enterprise.facebook.lintcode;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Code160_FindMinimuminRotatedSortedArrayIITest {
    private Code160_FindMinimuminRotatedSortedArrayII target;

    @Before
    public void setup() {
        this.target = new Code160_FindMinimuminRotatedSortedArrayII();
    }

    @Test
    public void testFind() {
        int[] arr = new int[]{1,2,1};
        int actual = this.target.findMin(arr);
        int expected = 0;
        assertEquals(expected, actual);
    }
}
