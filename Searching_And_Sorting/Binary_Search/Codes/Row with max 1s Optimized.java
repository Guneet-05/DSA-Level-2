class Solution {
    public int transitionPoint(int arr[], int l,int r) {
        // code here
        int lo = l;
        int hi = r;
        
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
        int hi = m-1;
        
        int ans =-1, noOfOnes = 0;
        for(int i=0;i<n;i++) {
            int transitionPt = transitionPoint(arr[i],0,hi);
            if(transitionPt != -1 && m - transitionPt > noOfOnes) {
                ans = i;
                noOfOnes = m - transitionPt;
                hi = transitionPt - 1;
            }
        }
        
        return ans;
    }
}
