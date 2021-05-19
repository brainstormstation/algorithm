package com.datastructure.frequency;

import java.util.ArrayList;
import java.util.List;

import com.datastructure.SubarraySum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubarraySumTest {
    private SubarraySum target;

    @Before
    public void setup() {
        this.target = new SubarraySum();
    }

    @Test
    public void testSubarraySum() {
        int[] arr = new int[] {1, 2, 3, -5, 1, 2, -3, 0};
        List<Integer> result = this.target.subarraySum(arr);
        List<Integer> expect = new ArrayList<>();
        expect.add(1);
        expect.add(3);
        Assert.assertEquals(expect, result);
    }
    
}
