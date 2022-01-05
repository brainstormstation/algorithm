package com.enterprise.facebook.lintcode;

import com.common.entity.ListNode;

/**
 * Description
 * Reverse a linked list from position m to n.
 */
public class Code36_ReverseLinkedListII {
    /**
     * @param head: ListNode head is the head of the linked list 
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode cur = head;
        ListNode pre = null;
        while ( m > 1) {
            pre = cur;
            cur = cur.next;
            m--;
            n--;
        }

        ListNode con = pre;
        ListNode tail = cur;
        ListNode next = null;
        while (n>0) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            n--;
        }
        if (con != null) {
            con.next = pre;
        } else {
            head = pre;
        }
        tail.next = cur;
        return head;
    }
}
