class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        
        for(int i=1;i<dp.length;i++) {
            int res = 0;
            for(int coin : nums) {
                if(i - coin >= 0) {
                    res += dp[i - coin];
                }
            }
            dp[i] = res;
        }
        
        return dp[target];
    }
}
