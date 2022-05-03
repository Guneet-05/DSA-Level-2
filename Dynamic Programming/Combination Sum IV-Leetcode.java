//Permutations Coin Change
class Solution {
    
    public int memo(int[] nums,int target, int[] dp) {
          
        //0 coins can make target 0
        //so there is 1 way
        
        if(target < 0) return 0;
        
        if(target == 0) return 1;
        
        //memoization
        if(dp[target] != -1) return dp[target];
        
        int totalPerms = 0;
        for(int i=0;i<nums.length;i++) {
            if(target - nums[i] >=0) {
                totalPerms += memo(nums,target-nums[i],dp);   
            }
        }
        
        return dp[target] = totalPerms;
    }
    
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp,-1);
        
        return memo(nums,target,dp);
    }
}
