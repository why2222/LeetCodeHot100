package com.leetcode.hot100;


import java.util.HashMap;
import java.util.Map;

/**
 * 题目：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Solution_03 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int left = 0, right = left + 1;
        int temp = 1;
        int res = 0;
        Map<Integer, Character> map = new HashMap<Integer, Character>();
        map.put(left, s.charAt(left));
        while (left < s.length() && right < s.length()) {
            if (map.containsValue(s.charAt(right))) {
                if (temp > res) res = temp;
                left++;
                temp--;
                map.remove(left - 1);
                if (map.isEmpty()) {
                    map.put(right, s.charAt(right));
                    right++;
                }
                if (left == right) {
                    right++;
                    temp = 0;
                }
            } else {
                map.put(right, s.charAt(right));
                if (map.size() > res) res = map.size();
                temp = res;
                if (right < s.length()) {
                    right++;
                } else {
                    return temp;
                }
            }
        }
        return res;
    }
}
