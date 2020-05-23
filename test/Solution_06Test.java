package com.leetcode.hot100;

import org.junit.Test;

public class Solution_06Test {
    @Test
    public void Test() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Solution_06 s = new Solution_06();
        System.out.println(s.binarySearch(array, 0, array.length - 1, 10));

    }
}
