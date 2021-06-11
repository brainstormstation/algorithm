package com.msb.basic.startup;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.lintcode.common.entity.ListNode;

import org.junit.Before;
import org.junit.Test;

public class AddTwoNumberTest {
    private AddTwoNumber target;

    @Before
    public void setup() {
        target = new AddTwoNumber();
    }

    @Test
    public void testAddTwoNumber() {
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(4);

        ListNode result = this.target.addTwoNumber(head1, head2);
        ListNode expect = new ListNode(7);
        expect.next = new ListNode(0);
        expect.next.next = new ListNode(8);

        while (result != null) {
            assertEquals(expect.val, result.val);
            expect = expect.next;
            result = result.next;
        }
    }
    
}
