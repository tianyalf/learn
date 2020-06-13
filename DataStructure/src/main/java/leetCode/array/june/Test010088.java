package main.java.leetCode.array.june;

import java.util.Arrays;

/**
 * @date:2020-06-01 23:05
 * @author:天涯沦落人
 * @description:88. 合并两个有序数组
 */
public class Test010088 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        Solution010088 so = new Solution010088();
        System.out.println();
        so.merge(nums1,m,nums2,n);
    }
}

class Solution010088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;
        int[] temp = new int[m + n];
        while (i >= 0 && j >= 0) {
            if (nums1[i] <= nums2[j]) {
                temp[index--] = nums2[j--];
            } else {
                temp[index--] = nums1[i--];
            }
        }
        while (i >= 0) {
            temp[index--] = nums1[i--];
        }
        while (j >= 0) {
            temp[index--] = nums2[j--];
        }
        System.out.println(Arrays.toString(temp));
    }
}