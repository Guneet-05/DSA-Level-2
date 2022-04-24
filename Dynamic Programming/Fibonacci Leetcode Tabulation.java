//The best solution is the 2 pointer
//Better than 2 pointer are some mathematical topics which are CP based.

class Solution {
    public int fib(int n) {
       
       if(n <= 1) return n; 
        
       int[] dp = new int[n+1];
       dp[0] = 0;
       dp[1] = 1;
       
       for(int i=2;i<dp.length;i++) {
           dp[i] = dp[i-1] + dp[i-2];
       } 
        
       return dp[n]; 
    }
}
