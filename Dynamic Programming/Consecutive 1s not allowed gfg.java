class Solution {
    int m = 1000000007;
    long countStrings(int n) {
        // code here
        if(n == 0) return 1;
        int N = n + 2;
        
        long[] dp = new long[N+1];
        dp[0] = 0l;
        dp[1] = 1l;
        
        for(int i=2;i<dp.length;i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % m;
        }
        
        return dp[N];
    }
}
