package com.company.topinterview.mediumcollection.selection;

public class QuickSelect {

    public static void main(String[] args) {
        int[] nums = new int[]{12, 3, 3, 7, 4, 19, 26};
        for (int i = 1; i <= nums.length; i++)
            System.out.println(i + "th smallest element is: " + new QuickSelect().getKthSmallestElement(nums, i));
    }

    public int getKthSmallestElement(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        int pivot = partition(nums, start, end);
        if (pivot == k)
            return nums[pivot];
        if (pivot < k)
            return quickSelect(nums, pivot + 1, end, k);
        return quickSelect(nums, start, pivot - 1, k);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = getLastElementAsPivot(l, r);
        int i = -1, j = l;
        while (j <= r) {
            if (nums[j] <= nums[pivot]) {
                if (i != -1) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    i++;
                }
            } else if (i == -1)
                i = j;

            j++;
        }
        i--;
        return i < 0 ? r : i;
    }

    private int getLastElementAsPivot(int l, int r) {
        return r;
    }

    private int getRandomElementAsPivot(int l, int r) {
        return l + ((int) Math.random()) % (r - l);
    }

   /* private int getMediansOfMediansAsPivot(int[] nums, int l, int r){

    }*/
}
