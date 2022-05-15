class Solution {
    
     public int memo(int curr,int[] nums,int prev,int n,int[][] dp) {
        
        if(curr == n + 1) {
            return 0;
        }
        
        if(dp[curr][prev] != -1) return dp[curr][prev];
        
        int yes = (prev == 0) ? memo(curr + 1,nums,1,n,dp) + nums[curr] : 0;
        int no = memo(curr + 1,nums,0,n,dp);
        
        return dp[curr][prev] = Math.max(yes,no);
    }
    
    public int rob(int[] nums,int start, int end) {
        int n = nums.length;
        int[][] dp = new int[n+1][2];
        for(int i=0;i<=n;i++) {
            for(int j=0;j<2;j++) {
                dp[i][j] = -1;
            }
        }
        
        return memo(start,nums,0,end,dp);
    }
    
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums,0,nums.length-2),rob(nums,1,nums.length-1));
    }
}
