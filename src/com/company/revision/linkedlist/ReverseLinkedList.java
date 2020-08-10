package com.company.revision.linkedlist;

public class ReverseLinkedList {
    static ListNode reverse(ListNode head) {
        ListNode nHead = null;
        ListNode curr = head;
        ListNode tmp;
        while (curr != null) {
            tmp = curr;
            curr = curr.next;
            tmp.next = nHead;
            nHead = tmp;
        }
        return nHead;
    }

}
