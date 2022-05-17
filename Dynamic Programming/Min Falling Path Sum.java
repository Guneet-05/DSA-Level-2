class Solution {
    
    public int memo(int row,int col,int[][] matrix,int[][] dp) {
        
        if(col < 0 || col >= matrix[0].length) return Integer.MAX_VALUE;
        
        if(row == matrix.length-1) return matrix[row][col];
        
        if(dp[row][col] != -1) return dp[row][col];
        
        int leftDown = memo(row + 1,col - 1,matrix,dp);
        int down = memo(row + 1,col,matrix,dp);
        int rightDown = memo(row + 1,col + 1,matrix,dp);
        
       return dp[row][col] = Math.min(down,Math.min(leftDown,rightDown)) + matrix[row][col];
    }
    
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i=0;i<dp.length;i++) {
            for(int j=0;j<dp[0].length;j++) {
                dp[i][j] = -1;
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int src=0;src<matrix[0].length;src++) {
            int path = memo(0,src,matrix,dp);
            min = Math.min(path,min);
        }
        
        return min;
    }
}
