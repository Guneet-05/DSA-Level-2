class Solution {
    public int maxProfit(int[] prices) {
        //consider yourself as potential selling day
        int min = prices[0];
        int profit = 0;
        
        for(int i=0;i<prices.length;i++) {
            min = Math.min(min,prices[i]);
            profit = Math.max(profit,prices[i] - min);
        }
        
        return profit;
    }
}
