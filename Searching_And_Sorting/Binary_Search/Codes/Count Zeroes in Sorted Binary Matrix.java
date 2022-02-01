class GfG
{
    int transitionPoint(int[][] arr,int row,int m) {
        int lo = 0;
        int hi = m-1;
        
        int pa = m;
        
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            
            if(arr[row][mid] == 1) {
                pa = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return pa;
        
    }
    /*you are required to complete this method*/
    int countZeros(int A[][], int N)
    {
        int totalZeroes = 0;
        // Your code here
        for(int i=0;i<N;i++) {
            int currZeroes = transitionPoint(A,i,N);
            totalZeroes += currZeroes;
        }
        
        return totalZeroes;
    }
}
