class Solution {
    
    public int memo(int[] nums,int idx, int prev,int[][] dp) {
        
        if(idx == nums.length) return 0;
        
        if(dp[idx][prev + 1] != -1) return dp[idx][prev + 1];
        
        int res1 = (prev == -1 || nums[idx] > nums[prev]) 
                    ? memo(nums,idx + 1,idx,dp) + 1: 0;
        
        int res2 = memo(nums,idx + 1,prev,dp);
        
        return dp[idx][prev + 1] = Math.max(res1,res2);
    }
    
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        
        for(int i=0;i<dp.length;i++) {
            for(int j=0;j<dp[0].length;j++) {
                dp[i][j] = -1;
            }
        }
        
        return memo(nums,0,-1,dp);
    }
}
