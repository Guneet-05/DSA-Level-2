class Solution {
    
    public boolean searchMatrixHelper(int[][] matrix, int target) {
        int lo = 0;
        int n = matrix.length, m = matrix[0].length;
        int hi = n*m-1;
        
        while(lo <= hi) {
            int midCell = lo + (hi-lo)/2;
            
            int rowIdx = midCell / m;
            int colIdx = midCell % m;
            
            if(matrix[rowIdx][colIdx] == target) return true;
            else if(matrix[rowIdx][colIdx] < target) lo = midCell + 1;
            else hi = midCell - 1;
        }
        
        return false;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        return searchMatrixHelper(matrix,target);
    }
}
