package com.enterprise.facebook.lintcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class Code17_SubsetsTest {
    private Code17_Subsets target;

    @Before
    public void setup() {
        this.target = new Code17_Subsets();
    }

    @Test
    public void testSubsets() {
        int[] input = new int[]{1,2,3};
        List<List<Integer>> actual = this.target.subsets(input);
        int[][] expected = new int[][]{{},{1},{1,2},{2}};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void testMethod() {
        int[] input = new int[]{1,2,3};
        List<List<Integer>> actual = this.subsets(input);
        int[][] expected = new int[][]{{},{1},{1,2},{2}};
        assertArrayEquals(expected, actual.toArray());
    }

    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, result, 0, new LinkedList<>());
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, int start, LinkedList<Integer> record) {
       for (int i=start; i<nums.length; i++) {
            record.add(nums[i]);
            result.add(new LinkedList<>(record));
            helper(nums, result, i+1, record);
            record.removeLast();
        }
    }
    
}
