class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0;
        int j = matrix[0].length-1;
        
        while(i<matrix.length && matrix[i][j] < target) {
            i++;
        }
        
        if(i >= matrix.length) {
            return false;
        } else if(matrix[i][j] == target) {
            return true;
        }
        
        while(j>=0 && matrix[i][j] > target) {
            j--;
        }
        
        if(j<0) {
            return false;
        } else if(matrix[i][j] == target) {
            return true;
        }
        
        return false;
    }
}
