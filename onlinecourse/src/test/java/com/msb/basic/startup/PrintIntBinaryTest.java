package com.msb.basic.startup;

import static org.junit.Assert.assertTrue;

import com.msb.basic.startup.PrintIntBinary;

import org.junit.Before;
import org.junit.Test;

public class PrintIntBinaryTest {
    private PrintIntBinary target;

    @Before
    public void setup() {
        this.target = new PrintIntBinary();
    }

    @Test
    public void testGetBinaryStr() {
        String result = this.target.getBinaryStr(Integer.MAX_VALUE);
        System.out.println(Math.pow(2.00,3.00));
        System.out.println(result);
    }
    
}
