package com.msb.datastructure.startup;

import com.common.entity.ListNode;

/**
 * <b>Description</b>
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumber {
    public ListNode addTwoNumber(ListNode head1, ListNode head2) {
        int len1 = listLength(head1);
        int len2 = listLength(head2);

        ListNode l = len1 > len2? head1: head2;
        ListNode s = len1 > len2? head2: head1;
        int carry = 0;
        ListNode num = new ListNode(0);
        ListNode head = num;
        while (l != null && s != null) {
            int val = l.val + s.val + carry;
            num.next = new ListNode(val%10);
            carry =  val / 10;
            num = num.next;
            l = l.next;
            s = s.next;            
        }

        while (l != null) {
            int val = l.val + carry;
            num.next = new ListNode(val%10);
            carry = val / 10;
            num = num.next;
            l = l.next;
        }

        if (carry != 0) {
            num.next = new ListNode(carry);
        }
        return head.next;
    }

    private int listLength(ListNode node) {
        int len = 0;
        while(node!=null) {
            len++;
            node = node.next;
        }
        return len;
    }
    
}
