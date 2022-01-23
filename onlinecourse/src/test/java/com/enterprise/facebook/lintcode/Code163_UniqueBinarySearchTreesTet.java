package com.enterprise.facebook.lintcode;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Code163_UniqueBinarySearchTreesTet {
    private Code163_UniqueBinarySearchTrees target;

    @Before
    public void setup() {
        this.target = new Code163_UniqueBinarySearchTrees();
    }

    @Test
    public void test() {
        int n = 4;
        int actual = this.target.numTrees(n);
        int expected = 5;
        assertEquals(expected, actual);
    }
}
