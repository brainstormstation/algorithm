package com.datastructure.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <b>Description</b>
 * <p>
 * Given an array S of n integers, 
 * are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 */
public class ThreeSum {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        Arrays.sort(numbers);
        List<List<Integer>> result = new ArrayList<>();
        if (numbers.length < 3) {
            return result;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (i!=0 && numbers[i] == numbers[i-1]) {
                continue;
            }
            findTwoSum(numbers, i, result);

        }
        return result;

    }

    private void findTwoSum(int[] numbers, int index, List<List<Integer>> result) {
        int left = index+1;
        int right = numbers.length - 1;
        int target = -numbers[index];
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                List<Integer> record = new ArrayList<>();
                record.add(numbers[index]);
                record.add(numbers[left]);
                record.add(numbers[right]);
                result.add(record);
                left++;
                right--;
                while (left < right && numbers[left] == numbers[left-1]) {
                    left++;
                }
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
