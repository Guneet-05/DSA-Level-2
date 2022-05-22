class Solution
{
	public int maxSumIS(int nums[], int n)  
	{  
	    //code here.
	    if(nums.length == 1) return nums[0];
        
        int[] dp = new int[nums.length];
        
        // Arrays.fill(dp,1);
        
        int maxSum = 0;
        
        
        for(int i=0;i<dp.length;i++) {
            dp[i] = nums[i];
            for(int j=0;j<i;j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i],dp[j] + nums[i]);
                } 
            }
            
            maxSum = Math.max(maxSum,dp[i]);
        }
        
        return maxSum;
	}  
}
