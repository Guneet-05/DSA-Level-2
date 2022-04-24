class Solution
{
    int mod = 1000000007;
    public int memo(int n, int m, int[] dp) {
        
        if(n < m) return 1;
        if(n == m) return 2;
        if(dp[n] != -1) return dp[n];
        
        int ans1 = memo(n-1,m,dp);
        int ans2 = memo(n-m,m,dp);
        
        return dp[n] = (ans1 + ans2) % mod;
    }
    
    public int countWays(int n, int m)
    {
        // Code here
        int[] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        return memo(n,m,dp);
    }
}
