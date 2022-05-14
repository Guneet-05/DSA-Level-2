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
    
    public int minTaps(int n, int[] ranges) {
        int[] jumps = new int[n+1];
    
        for(int i=0;i<n+1;i++) {
            int l = Math.max(0,i-ranges[i]);
            int r = Math.min(n,i+ranges[i]);
            jumps[l] = Math.max(jumps[l],r-l);
        }

        int[] dp = new int[jumps.length];
        Arrays.fill(dp,-1);
        int ans = memo(jumps,0,dp);
        if(ans == Integer.MAX_VALUE) return -1;
        else return ans;
                
    }
}
