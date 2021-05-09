package com.binarysearch;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TemplateTest {
    
    private BinarySearchTemplate template;
    
    @Before
    public void init() {
        this.template = new BinarySearchTemplate();
    }

    @Test
    public void testBinarySearch() {
        int[] nums = {1, 5, 9, 20, 140};
        int target = 20;
        int pos = template.binarySearch(nums, target);
        assertEquals(3, pos);
    }
}
