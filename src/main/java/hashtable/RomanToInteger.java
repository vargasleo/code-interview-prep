package hashtable;

import java.util.HashMap;
import java.util.Map;

// Leetcode - 13. Roman to Integer
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println("resultado: " + romanToInt("MCMXCIV"));
        System.out.println("resultado: " + romanToInt("IV"));
    }

    public static int romanToInt(String s) {

        Map<Character, Integer> romanToInt = new HashMap<>();

        romanToInt.put('I', 1);
        romanToInt.put('V', 5);
        romanToInt.put('X', 10);
        romanToInt.put('L', 50);
        romanToInt.put('C', 100);
        romanToInt.put('D', 500);
        romanToInt.put('M', 1000);

        char[] roman = s.toCharArray();
        int total = 0;
        for (int i = 0; i < roman.length - 1; i++) {
            int atual = romanToInt.get(roman[i]);
            if (romanToInt.get(roman[i + 1]) > atual) {
                total -= atual;
            } else {
                total += atual;
            }
        }
        total += romanToInt.get(roman[roman.length - 1]);
        return total;
    }


}
