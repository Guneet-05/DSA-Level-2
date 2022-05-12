class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        
        for(int i=0;i<nums.length;i++) {
            total += nums[i];
        }
        
        if(total % 2 != 0) return false;
        
        int target = total/2;
        
        int n = nums.length;
        boolean[] dp = new boolean[target + 1];
	    dp[0] = true;
	    
	    for(int i=1;i<=n;i++) {
	        boolean[] newDp = new boolean[target + 1];
	        for(int j=0;j<=target;j++) {
	            boolean no = dp[j];
	            boolean yes = (j >= nums[i - 1]) ? dp[j-nums[i-1]] : false;
	            
	            newDp[j] = (no || yes);
	        }
	        dp = newDp;
	    }
	    
	    return dp[target];
    }
}
