package com.msb.datastructure.startup;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import org.junit.Test;

public class BitMapTest {
    private BitMap target;

    @Test
    public void testBitCalculation() {
        int a = 42342;
        System.out.println(a % 5);
        System.out.println(a & 5);
        assertTrue(true);
    }

    @Test
    public void testBitMap() {
        int max = 10000;
        this.target = new BitMap(max);
        HashSet<Integer> set = new HashSet<>();
        int testTime = 10000000;
        for (int i=0; i< testTime; i++) {
            int num = (int)Math.random() * (max+1);
            double decide = Math.random();
            if (decide < 0.333) {
                this.target.add(num);
                set.add(num);
            } else if (decide < 0.666) {
                this.target.delete(num);
                set.remove(num);
            } else {
                assertEquals(set.contains(num), this.target.contains(num));
            }
        }
        for (int num=0; num <= max; num++) {
            assertEquals(set.contains(num), this.target.contains(num));
        }
    }

}
