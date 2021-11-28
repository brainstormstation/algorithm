package com.jiuzhang.datastructure.twopointers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PartitionArrayTest {
    private PartitionArray target;

    @Before
    public void setup() {
        this.target = new PartitionArray();
    }

    @Test
    public void testPartitionArray() {
        int[] arr = new int[] {2, 323, 12, 63, 29, 99, 120, 220};
        int k = 99;
        int pos = this.target.partitionArray(arr, k);
        assertEquals(4, pos);
    }
}
