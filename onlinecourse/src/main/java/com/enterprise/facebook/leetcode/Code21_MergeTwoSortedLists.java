package com.enterprise.facebook.leetcode;

import com.common.entity.ListNode;

public class Code21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode point = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                point.next = list1;
                list1 = list1.next;
            }
            else {
                point.next = list2;
                list2 = list2.next;
            }
            point = point.next;
        }

        if (list1!=null) {
            point.next = list1;
        }

        if (list2!= null) {
            point.next = list2;
        }

        return head.next;
    }
}
