package string;

import java.util.*;

// Leetcode - 3. Longest Substring Without Repeating Characters
class LongestSubstringWithoutRepChars {

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();

        Set<Character> characters = new HashSet<>();
        int start = 0;
        int end = 0;
        int max = 0;

        while (end < s.length()) {
            if (!characters.contains(chars[end])) {
                characters.add(chars[end]);
                end++;
                max = Math.max(characters.size(), max);
            } else {
                characters.remove(chars[start]);
                start++;
            }
        }
        return max;
    }
}
