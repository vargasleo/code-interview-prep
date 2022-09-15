package twopointers;

// Leetcode - 202. Happy Number
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(7));
    }

    private static int getNext(int n) {
        int next = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            next += d * d;
        }
        return next;
    }

    public static boolean isHappy(int n) {
        return isHappy(n, getNext(n));
    }

    private static boolean isHappy(final int turtle, int rabbit) {
        if (rabbit == 1) return true;
        rabbit = getNext(rabbit);
        if (rabbit == turtle) return false;
        return isHappy(getNext(turtle), getNext(getNext(rabbit)));
    }
}