class Solution{

	public int perfectSum(int arr[],int n, int target) 
	{ 
	    // Your code goes here
	    int[] dp = new int[target + 1];
	    dp[0] = 1;
	    
	    for(int i=1;i<=n;i++) {
	        int[] newDp = new int[target + 1];
	        for(int j=0;j<=target;j++) {
	            int no = dp[j];
	            int yes = (j >= arr[i - 1]) ? dp[j-arr[i-1]] : 0;
	            
	            newDp[j] = (no + yes) % 1000000007;
	        }
	        dp = newDp;
	    }
	    
	    return dp[target];
	} 
}
