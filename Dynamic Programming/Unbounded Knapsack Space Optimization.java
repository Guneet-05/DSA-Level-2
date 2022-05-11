class Solution{
    static int knapSack(int N, int caps, int cost[], int wt[])
    {
        // code here
        int[] dp = new int[caps + 1];
        
        for(int item=1;item<=N;item++) {
            for(int cap=1;cap <= caps;cap++) {
                int no = dp[cap];
                int yes = (cap >= wt[item - 1]) ?
                dp[cap - wt[item -1]] + cost[item-1] : -1;
                dp[cap] = Math.max(yes,no);
            }
        }
        
        return dp[caps];
    }
}
