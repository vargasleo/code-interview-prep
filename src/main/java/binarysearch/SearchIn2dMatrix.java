package binarysearch;

// Leetcode - 74. Search a 2D Matrix
public class SearchIn2dMatrix {

    public static void main(String[] args) {
        var matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println(searchMatrix(matrix, 3));
        System.out.println(searchMatrix(matrix, 13));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            if (ints[ints.length - 1] >= target) {
                return rec(ints, target, 0, ints.length - 1) != -1;
            }
        }
        return false;
    }

    private static int rec(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return rec(nums, target, start, mid - 1);
        } else {
            return rec(nums, target, mid + 1, end);
        }
    }
}

