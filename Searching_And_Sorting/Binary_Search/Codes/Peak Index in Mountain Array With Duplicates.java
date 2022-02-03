class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lo = 0;
        int hi = arr.length-1;
        
        while(lo <= hi) {
            int mid = lo +(hi-lo)/2;
            
            int lVal = mid - 1 >=0 ? arr[mid-1] : Integer.MIN_VALUE;
            int rVal = mid + 1 < arr.length ? arr[mid + 1] : Integer.MIN_VALUE;
            
            if(arr[mid] >lVal && arr[mid] > rVal) {
                return mid;
            } else if(rVal > arr[mid] && arr[mid] > lVal) {
                lo = mid +1;
            } else if(rVal < arr[mid] && arr[mid] < lVal)  {
                hi = mid - 1;
            } else {
                //O(n) worst case
                if(arr[lo] <= arr[hi]) lo++;
                else hi--;
            }
        }
        
        return -1;
    }
}
