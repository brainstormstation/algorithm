package com.enterprise.bytedance;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

/**
 * <b>Description</b>
 * <p>
 * Reverse a linked list.
 * <p>
 * https://www.lintcode.com/problem/35/?_from=enterprise&fromId=3
 */
public class ReverseLinkedList {
    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode pre = null
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}
