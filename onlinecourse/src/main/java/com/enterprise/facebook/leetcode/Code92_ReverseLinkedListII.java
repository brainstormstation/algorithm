package com.enterprise.facebook.leetcode;

import com.common.entity.ListNode;

public class Code92_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        ListNode pre = null;
        while (left > 1) {
            pre = cur;
            cur = cur.next;
            left--;
            right--;
        }

        ListNode con = pre;
        ListNode tail = cur;
        ListNode next = null;
        while (right > 0) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            right--;
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
