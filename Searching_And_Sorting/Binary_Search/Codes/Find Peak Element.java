class Solution {
    public int findPeakElement(int[] arr) {
        
        int lo = 0;
        int hi = arr.length - 1;
        
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            
            long lVal = mid -1 >= 0 ? arr[mid-1] : Long.MIN_VALUE;
            long rVal = mid + 1 < arr.length ? arr[mid + 1] : Long.MIN_VALUE;
            
            if(arr[mid] > lVal && arr[mid] > rVal) return mid;
            else if(arr[mid] < arr[mid + 1]) lo = mid +1;
            else hi = mid - 1;
        }
        
        return -1;
    }
}
