class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxValue = -1;
        for (int y = 0; y < accounts.length; y++) {
            int money = 0;
            for (int x = 0; x < accounts[0].length; x++) {
                money += accounts[y][x];
            }
            if (maxValue < money) {
                maxValue = money;
            }
        }
        return maxValue;
    }
}