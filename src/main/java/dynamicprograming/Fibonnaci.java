package dynamicprograming;

import java.util.HashMap;
import java.util.Map;

import static java.util.Optional.ofNullable;

// AlgoExpert - Nth Fibonacci
public class Fibonnaci {

    public static void main(String[] args) {
        System.out.println(fib(4, new HashMap<>()));
    }

    public static int getNthFib(int n) {
        return fib(n, new HashMap<>());
    }

    private static int fib(int n, Map<Integer, Integer> memo) {
        if (n == 1) return 0;
        if (n <= 3) return 1;
        return ofNullable(memo.get(n))
                .orElseGet(() -> {
                    int result = fib(n - 1, memo) + fib(n - 2, memo);
                    memo.put(n, result);
                    return result;
                });
    }
}
