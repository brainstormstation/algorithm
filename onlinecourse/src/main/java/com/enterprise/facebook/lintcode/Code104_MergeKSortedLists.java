package com.enterprise.facebook.lintcode;

import java.util.*;

import com.common.entity.ListNode;

/**
 * https://www.lintcode.com/problem/104
 * Description
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 */
public class Code104_MergeKSortedLists {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        PriorityQueue<ListNode> queue = new PriorityQueue<>((n1,n2)->(n1.val-n2.val));
        ListNode point = new ListNode(-1);
        ListNode head = point;
        for (ListNode node: lists) {
            if (node !=null) {
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            point.next = node;
            point = point.next;
            if (node.next !=null) {
                queue.offer(node.next);
            }
        }
        return head.next;

    }
}
