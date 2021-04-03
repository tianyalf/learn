package com.example.lf.springbootDemo.algorithm;

import java.util.Arrays;

/**
 * @createTime:2021/03/28 0:25
 * @author:luofeng30850
 */
public class SortTest02 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 23, 4, 9, 12, 7, 56, 21, 3};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

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
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
