package com.leetcode.hot100;

import org.apache.commons.lang3.StringUtils;

public class Solution_02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String num1 = "";
        String num2 = "";
        while (l1 != null) {
            num1 += Integer.toString(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            num2 += Integer.toString(l2.val);
            l2 = l2.next;
        }
        StringBuffer revNum1 = new StringBuffer(num1).reverse();
        StringBuffer revNum2 = new StringBuffer(num2).reverse();
        String sum = strAdd(revNum1.toString(), revNum2.toString());
        return strToList(String.valueOf(sum));
    }

    // 输出顺序有问题 debug
    public ListNode strToList(String num) {
        char[] chars = num.toCharArray();
        ListNode root = new ListNode(Character.getNumericValue(chars[chars.length - 1]));
        ListNode temp = root;
        for (int i = chars.length - 2; i > 0; i--) {
            ListNode node = new ListNode(Character.getNumericValue(chars[i]));
            temp.next = node;
            temp = node;
        }
        return root;
    }

    public String strAdd(String num1, String num2) {
        //翻转两个字符串，并转换成数组
        char[] a = new StringBuffer(num1).reverse().toString().toCharArray();
        char[] b = new StringBuffer(num2).reverse().toString().toCharArray();
        int lenA = a.length;
        int lenB = b.length;
        //计算两个长字符串中的较长字符串的长度
        int len = lenA > lenB ? lenA : lenB;
        int[] result = new int[len + 1];
        for (int i = 0; i < len + 1; i++) {
            //如果当前的i超过了其中的一个，就用0代替，和另一个字符数组中的数字相加
            int aint = i < lenA ? (a[i] - '0') : 0;
            int bint = i < lenB ? (b[i] - '0') : 0;
            result[i] = aint + bint;
        }
        //处理结果集合，如果大于10的就向前一位进位，本身进行除10取余
        for (int i = 0; i < result.length; i++) {
            if (result[i] >= 10) {
                result[i + 1] += result[i] / 10;
                result[i] %= 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        //该字段用于标识是否有前置0，如果有就不要存储
        boolean flag = true;
        for (int i = len; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            sb.append(result[i]);
        }
        return sb.toString().length() == 0 ? "0" : sb.toString();
    }
}
