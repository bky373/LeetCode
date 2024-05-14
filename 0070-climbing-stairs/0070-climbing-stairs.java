class Solution {
    public int climbStairs(int n) {
        if (n==1) {
            return n;
        }
        int stepsBy1 = 1;
        int stepsBy2 = 2;
        
        for (int i=3; i<n+1; i++) {
            int cur = stepsBy1 + stepsBy2;
            stepsBy1 = stepsBy2;
            stepsBy2 = cur;
        }
        return stepsBy2;
    }
}