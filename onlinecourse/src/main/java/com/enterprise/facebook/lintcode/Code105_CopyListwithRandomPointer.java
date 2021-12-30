package com.enterprise.facebook.lintcode;

import java.util.*;

/**
 * Description
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 */
public class Code105_CopyListwithRandomPointer {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    class RandomListNode {
            int label;
            RandomListNode next, random;
            RandomListNode(int x) { this.label = x; }
    };

    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode oldNode = head;
        RandomListNode newNode = new RandomListNode(head.label);
        map.put(head, newNode);
        while (oldNode!=null) {
            newNode.next = getClone(oldNode.next, map);
            newNode.random = getClone(oldNode.random, map);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }

        return map.get(head);
    }

    private RandomListNode getClone(RandomListNode node, Map<RandomListNode, RandomListNode> map) {
        if (node == null) {
            return node;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }
        RandomListNode newNode = new RandomListNode(node.label);
        map.put(node, newNode);
        return newNode;
    }
}
