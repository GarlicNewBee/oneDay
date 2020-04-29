package com.zxg.leetcode;

import com.zxg.leetcode.entity.ListNode;

public class Solution {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m  -1;
        int p2 = n - 1;
        int p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0)) {
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <l2.val) {
             l1.next = mergeTwoLists(l1.next, l2);
             return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static String replaceSpace(String s) {
        int length = s.length();
        char[] res = new char[length * 3];
        int index = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                res[index++] = '%';
                res[index++] = '2';
                res[index++] = '0';
            } else {
                res[index++] = c;
            }
        }

        return new String(res, 0, index);
    }
}
