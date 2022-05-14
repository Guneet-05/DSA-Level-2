class Solution {
    
    public int memo(int[] nums,int curr,int[] dp) {
        
        if(curr == nums.length -1) return 0;
        if(dp[curr] != -1) return dp[curr];
        int min = Integer.MAX_VALUE - 1;
        
        for(int js=1;js<=nums[curr];js++) {
            int smallAns = (curr + js < nums.length) ? memo(nums,curr + js,dp) : 0;
            min = Math.min(min,smallAns);
        } 
        
        return dp[curr] = min + 1;
        
    }
    
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return memo(nums,0,dp);
    }
}
