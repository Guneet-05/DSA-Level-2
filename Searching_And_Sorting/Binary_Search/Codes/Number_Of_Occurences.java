class Solution {
    
    int firstIndex(int[] arr, int n, int x) {
        int lo = 0;
        int hi = arr.length - 1;
        
        int pa = -1;
        while(lo <= hi) {
            int mid = lo+ (hi-lo)/2;
            
            if(arr[mid] == x) {
                pa = mid;
                hi = mid-1;
            } else if(arr[mid] > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return pa;
    }
    
    int lastIndex(int[] arr, int n, int x) {
        int lo = 0;
        int hi = arr.length - 1;
        
        int pa = -1;
        while(lo <= hi) {
            int mid = lo+ (hi-lo)/2;
            
            if(arr[mid] == x) {
                pa = mid;
                lo = mid + 1;
            } else if(arr[mid] > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return pa;
    }
    
    int count(int[] arr, int n, int x) {
        int fi = firstIndex(arr,n,x);
        int li = lastIndex(arr,n,x);
        
        if(fi == -1) {
            return 0;
        }
        
        return li - fi + 1;
    }
}
