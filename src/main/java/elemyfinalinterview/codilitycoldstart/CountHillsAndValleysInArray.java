package elemyfinalinterview.codilitycoldstart;

import java.util.*;

// Codility - Elemy - Count Hills and Valleys
// Leetcode - 2210. Count Hills and Valleys in an Array
class CountHillsAndValleysInArray {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,4,1,1,6,5}));
    }

    public static int solution(int[] A) {
        if (A.length == 0) return 0;
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (i == 0 || A[i] != A[i - 1]) {
                values.add(A[i]);
            }
        }
        int count = values.size() > 1 ? 2 : 1;
        for (int i = 1; i < values.size() - 1; i++) {
            if (values.get(i) > values.get(i - 1) && values.get(i) > values.get(i + 1)) {
                count++;
            }
            if (values.get(i) < values.get(i - 1) && values.get(i) < values.get(i + 1)) {
                count++;
            }
        }
        return count;
    }
}
