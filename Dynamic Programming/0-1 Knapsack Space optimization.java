class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int caps, int wt[], int cost[], int n) 
    { 
         // your code here 
         int[] dp = new int[caps + 1];
         for(int item=1;item<= cost.length;item++) {
             int[] newDp = new int[caps + 1];
             
             for(int cap=1;cap<=caps;cap++) {
                 int no = dp[cap];
                 int yes = (cap >= wt[item -1]) ?
                            (cost[item-1] + dp[cap - wt[item -1]]) : -1;
                 newDp[cap] = Math.max(yes,no);
             }
             
             dp = newDp;
         }
         
         return dp[caps];
    } 
}
