class Solution {
    public int lengthOfLIS(int[] nums) {
        
        if(nums.length == 1) return 1;
        
        int[] dp = new int[nums.length];
        
        Arrays.fill(dp,1);
        
        int maxLis = 0;
        
        
        for(int i=1;i<dp.length;i++) {
            for(int j=0;j<i;j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                } 
            }
            
            maxLis = Math.max(maxLis,dp[i]);
        }
        
        return maxLis;
    }
}
