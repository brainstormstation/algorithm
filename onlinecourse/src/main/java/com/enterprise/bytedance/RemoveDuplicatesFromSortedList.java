package com.enterprise.bytedance;

import com.common.entity.ListNode;

/**
 * <b>Description</b>
 * <p>
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * https://www.lintcode.com/problem/112/?_from=enterprise&fromId=3
 */
public class RemoveDuplicatesFromSortedList {
    /**
     * @param head: head is the head of the linked list
     * @return: head of linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        ListNode node = head;
        while (node.next!=null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
