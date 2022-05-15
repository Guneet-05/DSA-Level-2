class Solution {
    
    public int memo(int curr,int[] nums,int prev,int[][] dp) {
        
        if(curr == nums.length -1) {
            if(prev == 0) return nums[curr];
            return 0;
        }
        
        if(dp[curr][prev] != -1) return dp[curr][prev];
        
        int yes = (prev == 0) ? memo(curr + 1,nums,1,dp) + nums[curr] : 0;
        int no = memo(curr + 1,nums,0,dp);
        
        return dp[curr][prev] = Math.max(yes,no);
    }
    
    public int rob(int[] nums) {
        
        int[][] dp = new int[nums.length + 1][2];
        for(int i=0;i<dp.length;i++) {
            for(int j=0;j<2;j++) {
                dp[i][j] = -1;
            }
        }
        return memo(0,nums,0,dp);
    }
}
