package com.msb.datastructure.basic;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PrintAllSubSequenceTest {

    private PrintAllSubsequence target;

    @Before
    public void setup() {
        this.target = new PrintAllSubsequence();
    }

    @Test
    public void testSubs() {
        String str = "abc";
        List<String> result = target.subs(str);
        for (String e: result) {
            System.out.println(e);
        }
        assertTrue(true);
    }
    
}
