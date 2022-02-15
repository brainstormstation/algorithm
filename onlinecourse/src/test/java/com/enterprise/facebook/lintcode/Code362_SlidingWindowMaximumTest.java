package com.enterprise.facebook.lintcode;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Code362_SlidingWindowMaximumTest {
    private Code362_SlidingWindowMaximum target;

    @Before
    public void setup() {
        this.target = new Code362_SlidingWindowMaximum();
    }

    @Test
    public void test() {
        int[] input = new int[]{1,2,7,7,2};
        int k = 3;
        List<Integer> result = this.target.maxSlidingWindow(input, k);
        
    }
}
