class Solution{

    public int solve(int n,int[] dp) {
        
        if(n == 1) return 0;
        if(dp[n] != -1) return dp[n];
        //ans1 = -1, ans2 = /2 ans3 = /3
        int ans1 = 0, ans2 = 0, ans3 = 0;
        ans1 = solve(n-1,dp);
        ans2 = (n % 2 == 0) ? solve(n/2,dp) : Integer.MAX_VALUE;
        ans3 = (n % 3 == 0) ? solve(n/3,dp) : Integer.MAX_VALUE;
        
        int smallAns = Math.min(ans2,ans3);
        
        return dp[n] = Math.min(smallAns,ans1) + 1;
    }

	public int minSteps(int N) 
	{ 
	    int[] dp = new int[N + 1];
	    Arrays.fill(dp,-1);
	    return solve(N,dp);
	    
	} 
}
