package com.datastructure.binarysearch;

import static org.junit.Assert.assertTrue;

import com.datastructure.binarysearch.FindPeakElement;

import org.junit.Before;
import org.junit.Test;

public class FindPeakElementTest {

    private FindPeakElement target;
    @Before
    public void setup() {
        this.target = new FindPeakElement();
    }

    @Test
    public void findPeakTest() {
        int[] arr = new int[] {1,2,1,3,4,5,7,6};
        int peak = target.findPeak(arr);
        assertTrue("Incorrect answer!", peak == 1 || peak == 6);
    }
}
