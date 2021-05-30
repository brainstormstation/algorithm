package com.datastructure.binarysearch;

import static org.junit.Assert.assertEquals;

import com.datastructure.binarysearch.WoodCut;

import org.junit.Before;
import org.junit.Test;

public class WoodCutTest {
    private WoodCut target;

    @Before
    public void setup() {
        this.target = new WoodCut();
    }

    @Test
    public void testWoodCut() {
        int[] arr = new int[] {232, 124, 456};
        int k = 7;
        int len = this.target.woodCut(arr, k);
        assertEquals(114, len);
    }

    @Test
    public void testWoodCutWithEmptyLen() {
        int[] arr = new int[] {1, 2, 3};
        int k = 7;
        int len = this.target.woodCut(arr, k);
        assertEquals(0, len);
    }
}
