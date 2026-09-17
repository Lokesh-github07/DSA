class Solution {
    public boolean isPalindrome(int x) {
          // Negative numbers are not palindromes
        if (x < 0) {
            return false;
        }

        int original = x;
        int reverse = 0;

        while (x > 0) {
            int digit = x % 10;              // Get last digit
            reverse = reverse * 10 + digit;  // Build reversed number
            x = x / 10;                      // Remove last digit
        }

        return original == reverse;
    }
}