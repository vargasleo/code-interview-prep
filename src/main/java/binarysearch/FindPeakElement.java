package binarysearch;

// Leetcode - 162. Find Peak Element
public class FindPeakElement {

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{-2147483648,-2147483647}));
    }

    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        return findPeakElement(nums, 0, nums.length - 1);
    }

    private static int findPeakElement(int[] nums, int start, int end) {
        if (nums[start] > nums[start + 1]) return start;
        if (nums[end] > nums[end - 1]) return end;
        if (start == end) return start;
        int mid = (start + end) / 2;
        if (nums[mid] > nums[mid + 1]) return findPeakElement(nums, start, mid);
        return findPeakElement(nums, mid + 1, end);
    }
}
