public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    
    //prev = 0->red 1->blue 2->green
    public int memo(int[][] costs,int curr,int prev,int[][] dp) {

        if(curr == costs.length) return 0;

        if(prev != -1 && dp[curr][prev] != -1) return dp[curr][prev];

        int red = (prev != 0) ? memo(costs,curr + 1,0,dp) + costs[curr][0]: Integer.MAX_VALUE;
        int blue = (prev != 1) ? memo(costs,curr + 1,1,dp) + costs[curr][1] : Integer.MAX_VALUE;
        int green = (prev != 2) ? memo(costs,curr + 1,2,dp) + costs[curr][2] : Integer.MAX_VALUE;

        if(prev == -1) return Math.min(red,Math.min(blue,green));
        return dp[curr][prev] = Math.min(red,Math.min(blue,green));
    }
    
    public int minCost(int[][] costs) {
        // write your code here

        if(costs.length == 0) return 0;

        int n = costs.length;
        int[][] dp = new int[costs.length + 1][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for(int i=1;i<costs.length;i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][1],dp[i-1][0]);
        }

        return Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));

    }
}
