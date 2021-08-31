package com.msb.datastructure.startup;

import com.lintcode.common.entity.DoubleNode;
import com.lintcode.common.entity.ListNode;

public class ReverseLinkedList {
    
    public ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode next = null;
        while (node !=null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public DoubleNode reverese(DoubleNode node) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            node.last = next;
            pre = node;
            node = next;
        }
        return pre;
    }
}
