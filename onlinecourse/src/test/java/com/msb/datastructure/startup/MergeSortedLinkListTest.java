package com.msb.datastructure.startup;

import static org.junit.Assert.assertEquals;

import com.lintcode.common.entity.ListNode;
import com.msb.datastructure.startup.MergeSortedLinkList;

import org.junit.Before;
import org.junit.Test;

public class MergeSortedLinkListTest {
    private MergeSortedLinkList target;

    @Before
    public void setup() {
        this.target = new MergeSortedLinkList();
    }

    @Test
    public void testMergeSortedLinkList() {
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(6);

        ListNode result = this.target.mergeTwoLists(head1, head2);
        ListNode expect = new ListNode(2);
        expect.next = new ListNode(3);
        expect.next.next = new ListNode(4);
        expect.next.next.next = new ListNode(4);
        expect.next.next.next.next = new ListNode(5);
        expect.next.next.next.next.next = new ListNode(6);

        while (result != null) {
            assertEquals(expect.val, result.val);
            expect = expect.next;
            result = result.next;
        }
    }
    
}
