package com.enterprise.facebook.leetcode;

import org.junit.Before;
import org.junit.Test;

public class Code146_LRUCacheTest {
    private Code146_LRUCache target;

    @Before
    public void setup() {
        this.target = new Code146_LRUCache(2);
    }

    @Test
    public void testMethod() {
        this.target.set(2, 1);
        this.target.set(1, 1);
        this.target.get(1);
        this.target.set(4, 1);
        this.target.get(1);
        this.target.get(2);
    }
}
