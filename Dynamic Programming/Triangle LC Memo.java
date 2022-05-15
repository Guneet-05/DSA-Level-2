class Solution {
    
    public int memo(List<List<Integer>> triangle, int sr, int sc,int[][] dp) {
        if(sr == triangle.size() - 1) return triangle.get(sr).get(sc);
        
        if(dp[sr][sc] != Integer.MIN_VALUE) return dp[sr][sc];
        
        int down = memo(triangle,sr + 1,sc,dp);
        int rightDown = memo(triangle, sr + 1,sc + 1,dp);
        
        return dp[sr][sc] = (triangle.get(sr).get(sc)) + Math.min(down, rightDown);
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=n;j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        
        return memo(triangle,0,0,dp);
    }
}
