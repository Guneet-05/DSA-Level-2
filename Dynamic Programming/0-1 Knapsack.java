class Solution 
{ 
    static int memo(int cap, int item, int[] wt, int[] cost, int[][] dp) {
        
        if(item == wt.length) return 0; //no item no profit
        
        if(dp[cap][item] != -1) return dp[cap][item];
        
        int yes = (cap >= wt[item]) ? 
            memo(cap - wt[item],item + 1,wt,cost,dp) + cost[item] : -1;
        int no = memo(cap,item + 1,wt,cost,dp);
        
        return dp[cap][item] = Math.max(yes,no);
    }
    
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] dp = new int[W + 1][wt.length];
         for(int i=0;i<dp.length;i++) {
             for(int j=0;j<dp[0].length;j++) {
                 dp[i][j] = -1;
             }
         }
         
         return memo(W,0,wt,val,dp);
    } 
}
