package com.company.revision.linkedlist;

public class JosephusCircle {
    public static void main(String[] args) {
        ListNode h = new ListNode(8);
        ListNode g = new ListNode(7, h);
        ListNode f = new ListNode(6, g);
        ListNode e = new ListNode(5, f);
        ListNode d = new ListNode(4, e);
        ListNode c = new ListNode(3, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);
        h.next = a;
        System.out.println(findJosephus(a, 3).val);
    }

    static ListNode findJosephus(ListNode head, int M) {
        if (head == head.next) {
            System.out.println("The last one standing is " + head.val);
            return head;
        }
        for (int i = 1; i < M - 1; i++)
            head = head.next;
        System.out.println("Killing " + head.next.val);
        head.next = head.next.next;
        return findJosephus(head.next, M);
    }
}
