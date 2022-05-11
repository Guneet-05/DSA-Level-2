class Solution {
    public int maxProfit(int[] prices) {
       int[] sell = new int[prices.length];
       int[] buy = new int[prices.length];
        
       int min = prices[0]; 
       for(int i=0;i<sell.length;i++) {
           min = Math.min(min,prices[i]);
           if(i - 1 >= 0)
               sell[i] = Math.max(sell[i-1],prices[i] - min);
           else 
               sell[i] = prices[i] - min;
       } 
        
        int max = prices[prices.length-1];
        for(int i=buy.length-1;i>=0;i--) {
            max = Math.max(max,prices[i]);
            if(i + 1 < buy.length)
                buy[i] = Math.max(buy[i+1],max - prices[i]);
            else
                buy[i] = max - prices[i];
        }
        
        int maxProf = 0;
        for(int i=0;i<prices.length;i++) {
            maxProf = Math.max(maxProf,buy[i] + sell[i]);
        }
        
        return maxProf;
    }
}
