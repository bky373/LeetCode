class Solution {
    public int reverse(int x) {
        int rev = 0;
        int compareMinVal = Integer.MIN_VALUE / 10;
        int compareMaxVal = Integer.MAX_VALUE / 10;

        int compareMinR = Integer.MIN_VALUE % 10;
        int compareMaxR = Integer.MAX_VALUE % 10;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            
            if (rev < compareMinVal || rev > compareMaxVal) {
                return 0;
            }
            if ((rev == compareMinVal && pop < compareMinR) || (rev == compareMaxVal && pop > compareMaxR)) {
                return 0;
            }
            rev = (rev * 10) + pop;
        }
        return rev;
    }
}