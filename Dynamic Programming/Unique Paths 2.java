class Solution {
    
    public int memo(int sr, int sc, int dr, int dc, int[][] grid, int[][] dp) {
        
        if(sr >= grid.length || sc >= grid[0].length) return 0;
        
        if(grid[sr][sc] == 1) return 0;
        
        if(sr == dr && sc == dc) return 1;
        
        if(dp[sr][sc] != -1) return dp[sr][sc];
        
        int h = memo(sr,sc + 1,dr,dc,grid,dp);
        int v = memo(sr + 1,sc,dr,dc,grid,dp);
        
        return dp[sr][sc] = (h+v);
    }
    
    public int uniquePathsWithObstacles(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        //source is blocked or dest is blocked
        if(grid[0][0] == 1 || grid[grid.length-1][grid[0].length-1] == 1) return 0;
        
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m;i++) {
            for(int j=0;j<=n;j++) {
                dp[i][j] = -1;
            }
        }
        return memo(0,0,m-1,n-1,grid,dp);
    }
}
