package com.company.revision.arrays;

public class MergeTwoArrays {
    /*
     * Algorithm to merge an array of size 'n' into another array of size 'm+n' which contains only 'm' elements
     * Method 1: Insertion procedure of insertion sort: O(mn) time, O(1) space
     * Method 2: Merge procedure of merge sort in a new array and then copy it to original 'm+n array': O(m+n) time, O(m+n) space
     * Method 3 is shown below O(m+n) time, O(1) space:
     * */
    void mergeSmallIntoLarge(int[] large, int[] small) {
        int m = large.length - small.length;
        int n = small.length;
        int i;
        for (i = 0; i < m; i++) {
            large[m + i] = large[i];
        }
        int j = 0;
        merge(large, small, i, j);
    }

    private void merge(int[] large, int[] small, int i, int j) {
        int k = 0;
        while (i < large.length && j < small.length) {
            if (large[i] < small[j]) {
                large[k++] = large[i++];
            } else {
                large[k++] = small[j++];
            }
        }

    }

}
