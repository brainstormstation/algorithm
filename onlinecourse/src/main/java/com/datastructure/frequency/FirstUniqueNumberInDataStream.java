package com.datastructure.frequency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.common.entity.ListNode;

class DataStream {
    private ListNode head, tail;
    private HashMap<Integer, ListNode> numToPrev;
    private Set<Integer> duplicates;
    
    public DataStream() {
        head = new ListNode(0);
        tail = head;

        numToPrev = new HashMap<>();
        duplicates = new HashSet<>();
    }

    public void remove(int num) {
        ListNode pre = numToPrev.get(num);
        pre.next = pre.next.next;
        numToPrev.remove(num);

        if (pre.next != null) {
            numToPrev.put(pre.next.val, pre);
        } else {
            tail = pre;
        }
    }

    public void add(int num) {
        if (duplicates.contains(num)) {
            return;
        }

        if (numToPrev.containsKey(num)) {
            remove(num);
            duplicates.add(num);
        } else {
            ListNode node = new ListNode(num);
            numToPrev.put(num, tail);
            tail.next = node;
            tail = node;
        }
    }

    public int firstUnique() {
        if (head.next != null) {
            return head.next.val;
        }
        return -1;
    }
}
/**
 * <b>Description</b>
 * <p>
 * Given a continuous stream of data, write a function that returns the first unique number 
 * (including the last number) when the terminating number arrives. 
 * If the terminating number is not found, return -1.
 * <p>
 * https://www.lintcode.com/problem/685/?_from=ladder&fromId=161
 */
public class FirstUniqueNumberInDataStream {
    /**
     * @param nums: a continuous stream of numbers
     * @param number: a number
     * @return: returns the first unique number
     */
    public int firstUniqueNumber(int[] nums, int number) {
        // Write your code here
        DataStream ds = new DataStream();
        for (int i=0; i<nums.length; i++) {
            ds.add(nums[i]);
            if ( nums[i] == number) {
                return ds.firstUnique();
            }
        }
        return -1;
    }
}
