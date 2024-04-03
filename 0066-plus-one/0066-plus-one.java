class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] answer = new int[n + 1];
        int incr = 0;
        for (int i=n-1;i>=0; i--) {
            int tmp;
            if (i == n-1) {
                tmp = digits[i] + 1;
            } else {
                tmp = digits[i] + incr;
            }
            incr = 0;
            if (tmp > 9) {
                incr++;
            }
            answer[i] = tmp % 10;
        }
        if (incr == 1) {
            answer[0] = 1;
            return Arrays.copyOfRange(answer, 0, n+1);
        } else {
            return Arrays.copyOfRange(answer, 0, n);
        }
    }
}
