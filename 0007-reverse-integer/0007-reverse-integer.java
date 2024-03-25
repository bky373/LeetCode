class Solution {
    public int reverse(int x) {
        int y = 0;
        int compareMinVal = Integer.MIN_VALUE / 10;
        int compareMaxVal = Integer.MAX_VALUE / 10;

        int compareMinR = Integer.MIN_VALUE % 10;
        int compareMaxR = Integer.MAX_VALUE % 10;

        while (x != 0) {
            int tmp = x % 10;
            y += tmp;
            x /= 10;
            if (x != 0) {
                if (y < compareMinVal || y > compareMaxVal) {
                    y = 0;
                    break;
                }
                if ((y == compareMinVal && x < compareMinR) || (y == compareMaxVal && x > compareMaxR)) {
                    y = 0;
                    break;
                }
                y *= 10;
            }
        }
        return y;
    }
}