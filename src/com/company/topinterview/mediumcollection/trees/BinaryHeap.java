package com.company.topinterview.mediumcollection.trees;

public class BinaryHeap {
    private final int capacity;
    private final boolean isMax;
    private int[] nodes;
    private int size;

    public BinaryHeap(int capacity, boolean isMax) {
        this.capacity = capacity;
        this.isMax = isMax;
        this.size = 0;
    }

    public int findMinOrMax() {
        return nodes[0];
    }

    public int getParentIndex(int i) {
        if (i <= 0 || i >= size)
            return -1;
        return (i - 1) / 2;
    }

    public int getFirstChildIndex(int i) {
        int f = (i << 1) + 1;
        return f < size ? f : -1;
    }

    public int getSecondChildIndex(int i) {
        int s = (i << 1) + 2;
        return s < size ? s : -1;
    }

    // O(logn)
    public void percolateDown(int i) {
        int f = this.getFirstChildIndex(i);
        int s = this.getSecondChildIndex(i);
        if (f == -1)  // No subtrees
            return;
        int max;

        if (s == -1)  // Only left subtree
            max = f;
        else max = nodes[f] > nodes[s] ? f : s; // Both subtrees present

        if (nodes[i] >= nodes[max])
            return;

        int tmp = nodes[i];
        nodes[i] = nodes[max];
        nodes[max] = tmp;

        percolateDown(max);
    }

    //O(logN) :D
    public void delete() {
        if (size <= 0)
            return;
        nodes[0] = nodes[size - 1];
        nodes[size - 1] = 0;
        size--;
        percolateDown(0);
    }

    //O(logN) :D
    public void insert(int data) {
        if (size == capacity) {
            System.out.println("Already reached capacity");
            return;
        }
        size++;
        nodes[size - 1] = data;
        heapifyUp(size - 1);
    }

    //O(logn)
    private void heapifyUp(int i) {
        int p = getParentIndex(i);
        if (p == -1 || nodes[i] <= nodes[p])
            return;
        int tmp = nodes[p];
        nodes[p] = nodes[i];
        nodes[i] = tmp;
        heapifyUp(p);
    }
}
