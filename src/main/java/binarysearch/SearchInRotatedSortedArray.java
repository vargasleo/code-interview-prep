package binarysearch;

import static java.lang.Math.min;

// Leetcode - 33. Search in Rotated Sorted Array
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        var array = new int[]{1, 3};
        System.out.println(search(array, 1));
        var array2 = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(array2, 0));
        var array3 = new int[]{3,5,1};
        System.out.println(search(array3, 3));
        var array4 = new int[]{1,3};
        System.out.println(search(array4, 3));
        var array5 = new int[]{4,5,6,7,8,1,2,3};
        System.out.println(search(array5, 8));
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) return 0;
            return -1;
        }
        int pivot = indexOfPivot(nums, 0, nums.length - 1);
        if (nums[pivot] == target) return pivot;
        if (pivot == nums.length  - 1) return search(nums, target, 0, pivot);
        if (target < nums[0]) return search(nums, target, pivot + 1, nums.length - 1);

        return search(nums, target, 0, pivot);
    }

    private static int indexOfPivot(int[] nums, int start, int end) {
        if (nums[end] >= nums[start]) return end;
        int mid = (start + end) / 2;
        if (start == mid) return mid;
        if (nums[mid] > nums[start]) return indexOfPivot(nums, mid, end);
        return indexOfPivot(nums, start, mid);
    }

    private static int search(int[] nums, int target, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] > target) return search(nums, target, start, mid - 1);
        return search(nums, target, mid + 1, end);
    }
}
