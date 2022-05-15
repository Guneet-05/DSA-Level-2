class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        
        dp[dp.length-1][dp[0].length-1] = grid[grid.length-1][grid[0].length-1];
        
        for(int i=dp.length-1;i>=0;i--) {
            for(int j=dp[0].length-1;j>=0;j--) {
                if(i == dp.length-1 && j == dp[0].length -1) continue;
                int h = (j + 1 < dp[0].length) ? dp[i][j+1] : Integer.MAX_VALUE;
                int v = (i + 1 < dp.length) ? dp[i+1][j] : Integer.MAX_VALUE;
                dp[i][j] = Math.min(h,v) + grid[i][j];
            }
        }
        
        return dp[0][0];
    }
}
