package binarysearch;

import static java.lang.Math.min;

// Leetcode - 153. Find Minimum in Rotated Sorted Array
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(findMin(new int[]{1,2,3,4,5}));
        System.out.println(findMin(new int[]{1,2,3,4,5}));
        System.out.println(findMin(new int[]{1,2,3,4,5}));
        System.out.println(findMin(new int[]{1,2,3}));
    }

    public static int findMin(int[] num) {
        return findMin(num, 0, num.length - 1);
    }

    public static int findMin(int[] num, int start, int end) {
        if (start == end) return num[start];
        if ((end - start) == 1) return min(num[start], num[end]);
        int mid = start + (end - start) / 2;
        if (num[start] < num[end]) return num[start];
        else if (num[mid] > num[start]) return findMin(num, mid, end);
        return findMin(num, start, mid);
    }
}
