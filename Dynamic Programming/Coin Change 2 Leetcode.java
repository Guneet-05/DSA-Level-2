class Solution {
    
    public int memo(int[] nums,int lastCoin,int target, int[][] dp) {
          
        //0 coins can make target 0
        //so there is 1 way
        
        if(target < 0) return 0;
        
        if(target == 0) return 1;
        
        //memoization
        if(dp[target][lastCoin] != -1) return dp[target][lastCoin];
        
        int totalPerms = 0;
        for(int i=lastCoin;i<nums.length;i++) {
            if(target - nums[i] >=0) {
                totalPerms += memo(nums,i,target-nums[i],dp);   
            }
        }
        
        return dp[target][lastCoin] = totalPerms;
    }
    
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        for(int i=0;i<dp.length;i++) {
            for(int j=0;j<dp[0].length;j++) {
                dp[i][j] = -1;
            }
        }
        return memo(coins,0,amount,dp);
    }
}
