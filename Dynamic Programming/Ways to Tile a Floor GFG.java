class Solution {
    static Long numberOfWays(int N) {
        // code here
         long[] dp = new long[N + 1];
        if(N == 0) return 0l;
        if(N == 1) return 1l;
        if(N == 2) return 2l;
        
        dp[0] = 0l;
        dp[1] = 1l;
        dp[2] = 2l;
        
        for (int i = 3; i < dp.length; i++)
        {
          dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        
        return dp[N];
    }
};
