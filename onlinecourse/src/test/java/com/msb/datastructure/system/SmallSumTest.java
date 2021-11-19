package com.msb.datastructure.system;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SmallSumTest {
    private SmallSum target;

    @Before
    public void setup() {
        this.target = new SmallSum();
        
    }

    @Test
    public void testSmallSum() {
        int[] arr = new int[] {1,2,6,3,7,8,10};
        int expected = 0;
        for (int i=1; i<arr.length; i++) {
            for (int j=0; j<i; j++) {
                expected+= arr[j]<arr[i]?arr[j]:0;
            }
        }
        
        int ans = this.target.getSmallSum(arr);
        
        assertEquals(expected, ans);
    }
}
