
class Solution {
    int findMissing(int[] arr, int n) {
        // code here
        int lo = 0;
        int hi = n-1;
        
        int a = arr[0];
        int d = (arr[n-1] - arr[0]) / n;
        
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            
            if((a + mid*d) == arr[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return a+lo*d;
    }
}
