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

    @Test
    public void testLoopNode() {
        ListNode list1 = TestUtil.generateRandomLinkList(6, 100);
        ListNode list2 = TestUtil.generateRandomLinkList(8, 100);
        ListNode tail1 = list1;
        while (tail1.next!=null) {
            tail1 = tail1.next;
        }
        ListNode tail2 = list2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }
        tail1.next = list2;
        tail2.next = tail1;
        
        ListNode p = target.getLoopNode(list1);
        assertTrue(p == tail1);

    }

    @Test
    public void testGetCrossNodeNoCircle() {
        ListNode list1 = TestUtil.generateRandomLinkList(6, 100);
        ListNode list2 = TestUtil.generateRandomLinkList(3, 100);
        ListNode t2 = list2;
        while (t2.next != null) {
            t2 = t2.next;
        }
        int count = (int)(5 * Math.random());
        ListNode t1 = list1;
        while (count > 0) {
            t1 = t1.next;
            count--;
        }
        t2.next = t1;
        ListNode node = this.target.getCrossNodeNoCircle(list1, list2);
        assertTrue(node == t1);
    }
    
}
