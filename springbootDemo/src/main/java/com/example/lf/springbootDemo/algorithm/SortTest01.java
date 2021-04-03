package com.example.lf.springbootDemo.algorithm;

import java.util.Arrays;

/**
 * @createTime:2021/03/27 23:30
 * @author:luofeng30850
 */
public class SortTest01 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 23, 4, 9, 12, 7, 56, 21};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    //快速排序
    private static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = getMid(nums, left, right);
            quickSort(nums, left, mid - 1);
            quickSort(nums, mid + 1, right);
        }
    }

    private static int getMid(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (nums[right] >= pivot && left < right) {
                right--;
            }
            nums[left] = nums[right];
            while (nums[left] <= pivot && left < right) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
