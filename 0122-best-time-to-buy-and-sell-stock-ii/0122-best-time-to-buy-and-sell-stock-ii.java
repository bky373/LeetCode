class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int profit = 0;
        boolean hasStock = false;
        
        for (int i=0; i<len-1; i++) {
            int curr = prices[i];
            int next = prices[i+1];
            
            if (curr <= next && !hasStock) {
                profit -= curr;
                hasStock = true;
            }
            
            if (curr >= next && hasStock) {
                profit += curr;
                hasStock = false;
            }
        }
        
        if (hasStock) {
            profit += prices[len-1];
            hasStock = true;
        }
        return profit;
    }
}