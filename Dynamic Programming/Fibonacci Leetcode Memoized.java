class Solution {
    
    private int fib(int n, int[] dp) {
       
       if(n <= 1) return n;
       
       if(dp[n] != -1) return dp[n]; 
        
       int fibnm1 = fib(n-1,dp);
       int fibnm2 = fib(n-2,dp);
        
       dp[n] = fibnm1 + fibnm2; 
       
       return dp[n];
    }
    
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return fib(n,dp);
    }
}
