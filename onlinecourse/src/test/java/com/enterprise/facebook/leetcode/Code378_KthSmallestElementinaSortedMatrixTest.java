package com.enterprise.facebook.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Code378_KthSmallestElementinaSortedMatrixTest {
    private Code378_KthSmallestElementinaSortedMatrix target;

    @Before
    public void setup() {
        this.target = new Code378_KthSmallestElementinaSortedMatrix();
    }

    @Test
    public void testkthSmallest() {
        int[][] input = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        int expected = 13;
        int actual = this.target.kthSmallest(input, k);
        assertEquals(expected, actual);
    }
}
