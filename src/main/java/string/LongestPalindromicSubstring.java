package string;

// Leetcode - 5. Longest Palindromic Substring
class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int lenEvenPalindrome = lookAround(s, i, i);
            int lenOddPalindrome = lookAround(s, i, i + 1);
            int len = Math.max(lenEvenPalindrome, lenOddPalindrome);
            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    private int lookAround(String s, int left, int right) {
        if (s == null || s.length() < 1) return 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
