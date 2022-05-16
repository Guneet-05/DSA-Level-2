class Solution
{
    int mod = 1000000007;
    public long helper(int n,long[] dp) {
        
        if(n == 0 || n == 1) return 1l;
        
        if(dp[n] !=- 1) return dp[n];
        
        long single = helper(n-1,dp) % mod;
        long pair = ((n-1l) * helper(n-2,dp)) % mod;
        
        return dp[n] = (single + pair) % mod;
    }
    
    public long countFriendsPairings(int n) 
    { 
       //code here
       long[] dp = new long[n+1];
       Arrays.fill(dp,-1);
       return helper(n,dp);
       
    }
}    
