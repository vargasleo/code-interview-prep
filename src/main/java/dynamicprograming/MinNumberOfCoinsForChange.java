package dynamicprograming;

import java.util.Arrays;
import java.util.HashMap;

// AlgoExpert - Minimum number of coins for change
public class MinNumberOfCoinsForChange {

    public static void main(String[] args) {
        System.out.println(minNumberOfCoinsForChangeBottomUp(79, new int[]{1,5,10}));
        System.out.println(minNumberOfCoinsForChangeTopDown(79, new int[]{1,5,10}, new HashMap<>()));
    }

    public static int minNumberOfCoinsForChangeBottomUp(int n, int[] denoms) {
        final int[] mins = new int[n + 1];
        Arrays.fill(mins, n + 1);
        mins[0] = 0;
        for (int i = 1; i < mins.length; i++) {
            for (final int denom : denoms) {
                if (denom <= i) mins[i] = Math.min(mins[i - denom] + 1, mins[i]);
            }
        }
        if (mins[n] == n + 1) return -1;
        return mins[mins.length - 1];
    }

    public static int minNumberOfCoinsForChangeTopDown(int n, int[] denoms, HashMap<Integer, Integer> cache) {
        if (n < 0) return -1;
        if (n == 0) return 0;
        if (cache.containsKey(n)) return cache.get(n);
        int min = n + 1;
        for (final int denom : denoms) {
            final int result = minNumberOfCoinsForChangeTopDown(n - denom, denoms, cache);
            if (result != -1) min = Math.min(min, result + 1);
        }
        if (min == n + 1) {
            cache.put(n, -1);
            return -1;
        }
        cache.put(n, min);
        return min;
    }
}
