package TODOhackerrank;


import java.util.*;

import static java.util.stream.Collectors.joining;


/**
 * INPUT
 * STDIN           Function
 * -----           --------
 * 3               n = 3
 * {[()]}          first s = '{[()]}'
 * {[(])}          second s = '{[(])}'
 * {{[[(())]]}}    third s ='{{[[(())]]}}'
 * <p>
 * OUTPUT
 * YES
 * NO
 * YES
 */

class BracketsBrainFuckSolution {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static boolean verifyBalance(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check != '(') {
                        return false;
                    }
                    break;

                case '}':
                    check = stack.pop();
                    if (check != '{') {
                        return false;
                    }
                    break;

                case ']':
                    check = stack.pop();
                    if (check != '[') {
                        return false;
                    }
                    break;
            }
        }

        return (stack.isEmpty());
    }

    public static String isBalanced(String s) {
        if (verifyBalance(s)) {
            return "YES";
        } else {
            return "NO";
        }
    }


    public static void main(String[] args) {

        /**
         * {[()]}
         * {[(])}
         * {{[[(())]]}}
         */
        String c1 = "{[()]}";
        String c2 = "{[(])}";
        String c3 = "{{[[(())]]}}";

        System.out.println(isBalanced(c1));
        System.out.println(isBalanced(c2));
        System.out.println(isBalanced(c3));
    }
}



