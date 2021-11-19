package com.enterprise.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Description</b>
 * Given number n. Print number from 1 to n. According to following rules:
 * <p>
 * <ul>
 * <li> when number is divided by 3, print "fizz".</li>
 * <li> when number is divided by 5, print "buzz".</li>
 * <li> when number is divided by both 3 and 5, print "fizz buzz".</li>
 * <li> when number can't be divided by either 3 or 5, print the number itself.</li>
 * </ul>
 * <p>
 * https://www.lintcode.com/problem/9/?_from=enterprise&fromId=3
 * 
 */
public class FizzBuzz {
    /**
     * @param n: An integer
     * @return: A list of strings.
     */
    public List<String> fizzBuzz(int n) {
        // write your code here
        List<String> result = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            if (i<3) {
                result.add(String.valueOf(i));
            } else if (i%3 == 0 && i%5 ==0) {
                result.add("fizz buzz");
            } else if (i%5 == 0) {
                result.add("buzz");
            } else if (i%3 == 0) {
                result.add("fizz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}
