class Solution {
    public int transitionPoint(int arr[], int n) {
        // code here
        int lo = 0;
        int hi = n-1;
        
        int pa = -1;
        
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            
            if(arr[mid] == 0) {
                lo = mid + 1;
            } else {
                pa = mid;
                hi = mid -1;
            }
        }
        
        return pa;
    }
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int lo = 0, hi = m-1;
        
        int ans =-1, noOfOnes = 0;
        for(int i=0;i<n;i++) {
            int transitionPt = transitionPoint(arr[i],m);
            if(transitionPt != -1 && m - transitionPt > noOfOnes) {
                ans = i;
                noOfOnes = m - transitionPt;
                hi = transitionPt - 1;
            }
        }
        
        return ans;
    }
}
