package com.msb.datastructure.basic;

import com.lintcode.common.entity.DoubleNode;
import com.lintcode.common.entity.ListNode;

public class LinkedListOperations {
    public ListNode reverseLinkList(ListNode node) {
        ListNode pre = null;
        ListNode next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public void removeListNode(ListNode head, int target) {
        ListNode pre = null;
        while (head != null) {
            if (head.val == target) {
                break;
            }
            pre = head;
            head = head.next;
        }

        if (head != null) {
            pre.next = head.next;
            head = null;
        }

    }
}
