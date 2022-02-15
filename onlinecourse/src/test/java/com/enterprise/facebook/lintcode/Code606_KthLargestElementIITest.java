package com.enterprise.facebook.lintcode;

import org.junit.Before;
import org.junit.Test;

public class Code606_KthLargestElementIITest {
    private Code606_KthLargestElementII target;

    @Before
    public void setup() {
        this.target = new Code606_KthLargestElementII();
    }

    @Test
    public void testKth() {
        int[] input = new int[]{3,2,1,5,6,4};
        int k = 2;
        int actual = this.target.kthLargetsElement(input, k);
        int expected = 10904;

    }
}
