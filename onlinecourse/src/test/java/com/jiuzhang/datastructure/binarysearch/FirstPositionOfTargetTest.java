package com.lintcode.datastructure.binarysearch;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class FirstPositionOfTargetTest {

    private FirstPositionOfTarget target;
    @Before
    public void setup() {
        this.target = new FirstPositionOfTarget();
    }

    @Test
    public void testBinarySearch() {
        int[] nums = {1, 5, 5, 5, 9, 10, 200};
        int target = 5;
        int pos = this.target.binarySearch(nums, target);
        assertEquals(1, pos);
    }
    
}
