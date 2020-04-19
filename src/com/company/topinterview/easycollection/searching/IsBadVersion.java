package com.company.topinterview.easycollection.searching;

public class IsBadVersion {
    final static int firstBadVersion = 1702766719;

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }

    public static int firstBadVersion(int n) {
        int start = 1, end = n, mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static int firstBadVersionUnoptimized(int n) {
        int start = 1, end = n, mid;
        while (true) {
            mid = start + (end - start) / 2;
            if (!isBadVersion(mid)) {
                if (isBadVersion(mid + 1))
                    return mid + 1;
                start = mid + 1;
            } else {
                if (!isBadVersion(mid - 1))
                    return mid;
                end = mid - 1;
            }

        }
    }

    private static boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }
}
