package math;

// Leetcode - 9. Palindrome Number
class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int start = x;
        int reversed = 0;
        while (x != 0) {
            if (reversed < Integer.MIN_VALUE / 10 || reversed > Integer.MAX_VALUE / 10)
                return false;
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return reversed == start;
    }
}
