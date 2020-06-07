package com.company.topinterview.mediumcollection.trees;

import java.util.ArrayList;
import java.util.List;

public class FindKthSmallestElement {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    static int size;

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(1);
        a.add(4);
        a.add(3);
        a.add(2);
        System.out.println(new FindKthSmallestElement().kthsmallest(a, 3));
    }

    private static int getParentIndex(int i) {
        if (i <= 0 || i >= size)
            return -1;
        return (i - 1) / 2;
    }

    private static int getFirstChildIndex(int i) {
        int f = (i << 1) + 1;
        return f < size ? f : -1;
    }

    private static int getSecondChildIndex(int i) {
        int s = (i << 1) + 2;
        return s < size ? s : -1;
    }

    private static void percolateDown(int i, int[] nodes) {
        int f = getFirstChildIndex(i);
        int s = getSecondChildIndex(i);
        if (f == -1)  // No subtrees
            return;
        int min;

        if (s == -1)  // Only left subtree
            min = f;
        else min = nodes[f] < nodes[s] ? f : s; // Both subtrees present

        if (nodes[i] <= nodes[min])
            return;

        int tmp = nodes[i];
        nodes[i] = nodes[min];
        nodes[min] = tmp;

        percolateDown(min, nodes);
    }

    private static void delete(int[] nodes) {
        if (size <= 0)
            return;
        nodes[0] = nodes[size - 1];
        nodes[size - 1] = 0;
        size--;
        percolateDown(0, nodes);
    }

    public int kthsmallest(final List<Integer> a, int k) {
        int[] arr = new int[a.size()];
        int n = arr.length;
        size = n;
        int i;
        for (i = 0; i < n; i++)
            arr[i] = a.get(i);
        for (i = getParentIndex(n - 1); i >= 0; i--)
            percolateDown(i, arr);
        return findInKLogN(k, arr);
    }

    private int findInKLogN(int k, int[] arr) {
        int i;
        for (i = 1; i < k; i++) // Delete k-1 small elements
            delete(arr);
        return arr[0]; // kth smallest element
    }
}
