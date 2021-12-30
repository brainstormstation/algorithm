package com.enterprise.facebook.lintcode;

import com.common.entity.ListNode;

public class Code165_MergeTwoSortedLists {
    /**
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode head = new ListNode(0);
        ListNode point = head;
        while (l1!=null && l2!=null) {
            if (l1.val<l2.val) {
                point.next = l1;
                l1 = l1.next;
            }
            else {
                point.next = l2;
                l2 = l2.next;
            }
            point = point.next;

        }

        if (l1!=null) {
            point.next = l1;
        }

        if (l2!=null) {
            point.next = l2;
        }
        return head.next;
    }
}
