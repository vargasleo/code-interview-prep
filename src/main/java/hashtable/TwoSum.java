package hashtable;

import java.util.HashMap;

// Leetcode - 1. Two Sum
class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        final var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            final var rest = target - nums[i];
            if (map.containsKey(rest)) {
                return new int[]{map.get(rest), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }
}
