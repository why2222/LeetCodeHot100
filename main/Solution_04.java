package com.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_04 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 + len2 == 0) {
            return 0;
        }
        int[] marge = new int[len1 + len2];
        for (int i = 0; i < len1 + len2; i++) {
            if (i < len1) {
                marge[i] = nums1[i];
            } else {
                marge[i] = nums2[i - len1 - 1];
            }
        }
        Arrays.sort(marge);
        return marge.length % 2 == 0 ? ((double) marge[(len1 + len2) / 2] + (double) marge[(len1 + len2) / 2 - 1]) / 2 : (double) marge[(len1 + len2) / 2];
    }
}
