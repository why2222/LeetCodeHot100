package com.leetcode.hot100;

public class Solution_01Test {

    @org.junit.Test
    public void Solution_01Test() {
        int[] arr = {2, 7, 11, 15};
        Solution_01 s = new Solution_01();
        int[] res = s.twoSum(arr, 9);
        for (int n : res) {
            System.out.println(n);
        }
    }
}
