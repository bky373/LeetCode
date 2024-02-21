class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x;
        int r = 0;
        boolean exceed = false;
        
        while (temp != 0) {
            r += temp % 10;
            temp /= 10;

            if (r > Integer.MAX_VALUE / 10) {
                exceed = true;
                break;
            }
            r *= 10;
        }
        if (!exceed) {
            r /= 10;
        }
        return r == x;
    }
}
