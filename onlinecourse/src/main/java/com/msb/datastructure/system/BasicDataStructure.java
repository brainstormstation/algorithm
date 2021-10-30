package com.msb.datastructure.system;

import com.common.entity.DoubleNode;
import com.common.entity.Node;

public class BasicDataStructure {
    public Node reverseLinkedList(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node pre = null;
        Node next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public Node removeValue(Node head, int val) {
        if (head == null) {
            return head;
        }

        while(head!=null && head.val == val) {
            head = head.next;
        }

        Node pre = head;
        Node cur = head;
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
