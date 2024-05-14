class Solution {
    public int climbStairs(int n) {
        if (n==1 || n==2) {
            return n;
        }
        int stepsBy1 = 1;
        int stepsBy2 = 2;
        int cur = stepsBy1 + stepsBy2;
        
        for (int i=4; i<n+1; i++) {
            stepsBy1 = stepsBy2;
            stepsBy2 = cur;
            cur = stepsBy1 + stepsBy2;
        }
        return cur;
    }
}