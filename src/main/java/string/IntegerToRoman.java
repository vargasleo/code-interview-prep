package string;

import java.util.HashSet;
import java.util.Set;

// Leetcode - 12. Integer to Roman
class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(10));
    }

    public static String intToRoman(int num) {
        int[] ints = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder sb = new StringBuilder();
        for (int i = ints.length - 1; i >= 0 && num > 0; i--) {
            while (num >= ints[i]) {
                num -= ints[i];
                sb.append(roman[i]);
            }
        }
        return sb.toString();
    }
}
