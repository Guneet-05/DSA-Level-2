class Solution {
    public int maxProfit(int[] prices) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        
        buy[0] = -prices[0];
        sell[0] = 0;
        
        if(prices.length > 1) {
            buy[1] = Math.max(sell[0] - prices[1],buy[0]);
            sell[1] = Math.max(buy[0] + prices[1], sell[0]);
        }
        
        for(int i=2;i<prices.length;i++) {
            buy[i] = Math.max(sell[i - 2] - prices[i],buy[i - 1]);
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
        }
        
        return sell[prices.length - 1];
    }
}
