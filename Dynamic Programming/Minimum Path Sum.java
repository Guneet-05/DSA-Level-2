class Solution {
    
    public int memo(int[][] grid, int sr, int sc,int[][] dp) {
        
        if(sr == grid.length-1 && sc == grid[0].length-1) return grid[sr][sc];
        
        if(dp[sr][sc] != -1) return dp[sr][sc];
        
        int h = (sc + 1 < grid[0].length) ? memo(grid,sr,sc + 1,dp) : Integer.MAX_VALUE;
        int v = (sr + 1 < grid.length) ? memo(grid,sr + 1,sc,dp) : Integer.MAX_VALUE;
        
        return dp[sr][sc] = Math.min(h,v) + grid[sr][sc];
    }
    
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        
        for(int i=0;i<dp.length;i++) {
            for(int j=0;j<dp[0].length;j++) {
                dp[i][j] = -1;
            }
        }
        
        
        return memo(grid,0,0,dp);
    }
}
