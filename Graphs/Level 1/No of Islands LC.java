class Solution {
    //2 means visited
    //1 means land
    //0 means water
    public int numIslands(char[][] grid) {
        
        int count = 0;
        
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] != '0' && grid[i][j] != '2') {
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public void dfs(char[][] grid, int sr, int sc) {
        
        if(sr < 0 || sr >= grid.length || sc < 0 || sc >= grid[0].length) return;
        
        if(grid[sr][sc] == '0' || grid[sr][sc] == '2') return;
        
        grid[sr][sc] = '2';
        
        dfs(grid,sr - 1,sc); //up call
        dfs(grid, sr, sc + 1); //right call
        dfs(grid, sr + 1,sc); //down call
        dfs(grid,sr, sc - 1); //left call
    }
}
