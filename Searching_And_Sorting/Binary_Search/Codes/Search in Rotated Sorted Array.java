class Solution {
    public int search(int[] arr, int target) {
        
        int lo = 0;
        int hi = arr.length-1;
        
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            
            if(arr[mid] == target) {
                return mid;
            } 
            if(arr[lo] <= arr[mid]) {
                if(target >= arr[lo] && target < arr[mid]) {
                    hi = mid -1;
                } else {
                    lo = mid + 1; 
                }
            } 
            else  {
                if(target > arr[mid] && target <= arr[hi]) {
                    lo  = mid + 1;
                } else {
                    hi = mid -1;
                }
            } 
        }
        
        return -1;
    }
}
