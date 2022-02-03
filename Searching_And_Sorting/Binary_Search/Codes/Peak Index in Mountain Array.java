class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lo = 0;
        int hi = arr.length-1;
        
        while(lo <= hi) {
            int mid = lo +(hi-lo)/2;
            
            int lVal = mid - 1 >=0 ? arr[mid-1] : Integer.MIN_VALUE;
            int rVal = mid + 1 < arr.length ? arr[mid + 1] : Integer.MAX_VALUE;
            
            if(arr[mid] >lVal && arr[mid] > rVal) {
                return mid;
            } else if(arr[mid + 1] > arr[mid]) {
                lo = mid +1;
            } else if(arr[mid + 1] < arr[mid]) {
                hi = mid - 1;
            }
        }
        
        return -1;
    }
}
