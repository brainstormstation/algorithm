package com.enterprise.facebook.leetcode;

import java.util.PriorityQueue;

import com.common.entity.ListNode;

public class Code23_MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((n1,n2)->(n1.val-n2.val));

        for (ListNode node : lists) {
            if (node!=null) {
                queue.offer(node);
            }
        }
        
        ListNode point = new ListNode(0);
        ListNode head = point;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            point.next = node;
            point = point.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return head.next;
    }
}
