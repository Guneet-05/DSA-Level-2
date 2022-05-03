class Solution {
    public int change(int target, int[] nums) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for(int coin :  nums) {
            for(int i=1;i<=target;i++) {
                if(i >= coin) {
                    dp[i] += dp[i-coin];
                }
            }
        }
        
        return dp[target];
    }
}
