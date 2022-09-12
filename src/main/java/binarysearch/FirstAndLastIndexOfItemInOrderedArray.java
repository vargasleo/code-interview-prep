package binarysearch;

import java.util.Arrays;

// Leetcode - 34. Find First and Last Position of Element in Sorted Array
public class FirstAndLastIndexOfItemInOrderedArray {

    public static void main(String[] args) {
        var array = new int[]{1, 2, 3, 3, 3, 3, 4, 7, 8, 8};
        System.out.println(Arrays.toString(searchRange(array, 3)));
    }

    public static int[] searchRange(int[] nums, int target) {
        return rec(nums, target, 0, nums.length - 1);
    }

    private static int[] rec(int[] nums, int target, int start, int end) {
        if (start > end) return new int[]{-1, -1};
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            int left = mid;
            int right = mid;
            while (left > 0 && nums[left - 1] == target) left--;
            while (right < nums.length - 1 && nums[right + 1] == target) right++;
            return new int[]{left, right};
        } else if (nums[mid] > target) return rec(nums, target, start, mid - 1);
        return rec(nums, target, mid + 1, end);
    }
}
