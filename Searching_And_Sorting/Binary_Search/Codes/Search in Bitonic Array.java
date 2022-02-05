public class Solution {
    
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

    
    public int binarySearch(int[] arr, int lo, int hi, int target, boolean isInc) {

       while( lo <= hi) {

            int mid = lo + (hi-lo)/2;

            if(arr[mid] == target) return mid;
            else if(isInc == true) {
                if(arr[mid] > target) hi = mid - 1;
                else lo = mid + 1;
            } else {
                if(arr[mid] > target) lo = mid + 1;
                else hi = mid -1;
            }
       }


        return -1;
    }

    public int solve(int[] A, int B) {
        int peakIdx = peakIndexInMountainArray(A);

        if(A[peakIdx] == B) return peakIdx;
        else if(B > A[peakIdx]) return -1;
        int left = binarySearch(A,0,peakIdx-1,B,true);
        if(left != -1) return left;
        int right = binarySearch(A,peakIdx + 1,A.length-1,B,false);
        return right; 
    }


}
