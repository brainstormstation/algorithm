package com.lintcode.datastructure.memorysearch;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class WordBreakIIITest {
    private WordBreakIII target;

    @Before
    public void setup() {
        this.target = new WordBreakIII();
    }

    @Test
    public void testWordBreak3() {
        String input = "CatMat";
        Set<String> dict = new HashSet<String>();
        dict.add("Cat");
        dict.add("Mat");
        dict.add("Ca");
        dict.add("tM");
        dict.add("at");
        dict.add("C");
        dict.add("Dog");
        dict.add("og");
        dict.add("Do");
        int result = this.target.wordBreak3(input, dict);
        assertEquals(3, result);

    }
    
}
