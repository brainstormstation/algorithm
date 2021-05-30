package com.datastructure.binarysearch;

import static org.junit.Assert.assertEquals;

import com.datastructure.binarysearch.LastPositionOfTarget;

import org.junit.Before;
import org.junit.Test;

public class LastPositionOfTargetTest {
    private LastPositionOfTarget target;

    @Before
    public void setup() {
        this.target = new LastPositionOfTarget();
    }

    @Test
    public void testLastPosition() {
        int[] nums = {1, 2, 3, 4, 4, 4, 4, 10};
        int target = 4;
        int pos = this.target.lastPosition(nums, target);
        assertEquals(6, pos);
    }
}
