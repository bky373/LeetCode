class Solution {
    public boolean isPalindrome(int x) {
        // Special cases: Negative numbers and numbers ending with 0 are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int reversed = 0;
        while (x > reversed) {
            // Reverse the number by adding the last digit to reversed
            reversed = reversed * 10 + x % 10;
            // Move to the next digit in x
            x /= 10;
        }
        
        // If the length of x is odd, we can ignore the middle digit
        return x == reversed || x == reversed / 10;
    }
}
