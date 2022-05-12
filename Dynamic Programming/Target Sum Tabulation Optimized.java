class Solution {
    
    public int countTargetSumSubset(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
	    dp[0] = 1;
	    
	    for(int i=1;i<=n;i++) {
	        int[] newDp = new int[target + 1];
	        for(int j=0;j<=target;j++) {
	            int no = dp[j];
	            int yes = (j >= nums[i - 1]) ? dp[j-nums[i-1]] : 0;
	            
	            newDp[j] = (no + yes);
	        }
	        dp = newDp;
	    }
	    
	    return dp[target];
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int x : nums) total += x;
        
        if(target > total) return 0;
        if((total - target) %2 == 1) return 0;
        
        return countTargetSumSubset(nums,(total-target)/2);
    }
}
