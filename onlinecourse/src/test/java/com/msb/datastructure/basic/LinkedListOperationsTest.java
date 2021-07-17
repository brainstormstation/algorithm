package com.msb.datastructure.basic;

import static org.junit.Assert.assertTrue;

import com.lintcode.common.entity.ListNode;
import com.testutil.TestUtil;

import org.junit.Before;
import org.junit.Test;

public class LinkedListOperationsTest {
    private LinkedListOperations target;

    @Before
    public void setup() {
        this.target  = new LinkedListOperations();
    }

    @Test
    public void testPartition() {
        ListNode head = TestUtil.generateRandomLinkList(10, 100);
        int pivoid = 20;
        ListNode pHead = target.partition(head, pivoid);
        while (pHead.val < pivoid) {
            assertTrue(pHead.val < pivoid);
            pHead = pHead.next;
        }

        while (pHead.val == pivoid) {
            assertTrue(pHead.val == pivoid);
            pHead = pHead.next;
        }

        while (pHead != null) {
            assertTrue(pHead.val > pivoid);
            pHead = pHead.next;
        }

    }

    @Test
    public void testCopyLinkedList1() {
        ListNode head = TestUtil.generateRandomLinkList(10, 100);
        ListNode pHead = target.copyLinkedList1(head);
        while (pHead != null) {
            assertTrue(pHead!=head && pHead.val == head.val);
            pHead = pHead.next;
            head = head.next;
        }

    }
    
}
