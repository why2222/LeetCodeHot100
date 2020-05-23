package com.leetcode.hot100;


public class Solution_06 {
    public String convert(String s, int numRows) {
        return null;
    }

    public int binarySearch(int[] array, int low, int high, int target) {
        if (low > high ) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (array[mid] < target) {
            return binarySearch(array, mid + 1, high, target);
        }
        if (array[mid] > target){
            return binarySearch(array, low, mid - 1, target);
        }
        return array[mid];
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//            if (array[mid] < target) {
//                low = mid + 1;
//            } else if (array[mid] > target) {
//                high = mid - 1;
//            } else {
//                return array[mid];
//            }
//        }
//        return -1;
    }
}
