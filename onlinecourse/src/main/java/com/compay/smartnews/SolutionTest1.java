package com.compay.smartnews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class SolutionTest1 {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length == 0) {
            return 1;
        }
        Arrays.sort(A);
        // Remove the duplicates
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (Integer i: A) {
            if (!set.contains(i) && i>0) {
                list.add(i);
                set.add(i);
            }
        }        
        if (list.size() == 0) {
            return 1;
        }
        for (int i = 0; i<list.size(); i++) {
            if (list.get(i)!=(i+1)) {
                return i+1;
            }
        }
        return list.size()+1;
    }
}
