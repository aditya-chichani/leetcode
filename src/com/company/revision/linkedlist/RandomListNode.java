package com.company.revision.linkedlist;

public class RandomListNode {
    int val;
    RandomListNode next;
    RandomListNode random;

    RandomListNode() {
    }

    RandomListNode(int val) {
        this.val = val;
    }

    public RandomListNode(int val, RandomListNode next) {
        this.val = val;
        this.next = next;
    }

    public RandomListNode(int val, RandomListNode next, RandomListNode random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
