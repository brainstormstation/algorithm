package com.msb.datastructure.system;

import com.common.entity.DoubleNode;
import com.common.entity.ListNode;

public class BasicDataStructure {
    public ListNode reverseLinkedList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

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

    public ListNode removeValue(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        while(head!=null && head.val == val) {
            head = head.next;
        }

        ListNode pre = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;                
            }
            else {
                pre = cur;
            }
            cur = cur.next;
            
        }
        return head;
    }

    public DoubleNode reverseDoubleLinkedList(DoubleNode node) {
        DoubleNode pre = null;
        DoubleNode next = null;
         while (node != null) {
            next = node.next;
            node.next = pre;
            node.pre = next;
            pre = node;
            node = next; 
         }
         return pre;
    }
}
