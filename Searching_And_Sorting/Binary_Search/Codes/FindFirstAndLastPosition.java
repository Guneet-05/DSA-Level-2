package Searching_And_Sorting.Binary_Search.Codes;

public class FindFirstAndLastPosition {
    
    public static void main(String[] args) {
        
    }
    
    public int[] searchRange(int[] nums, int target) {
        
        int[] ans = new int[2];
        ans[0] = firstIndex(nums,target);
        ans[1] = lastIndex(nums,target);
        
        return ans;
    }
    
    private int firstIndex(int[] arr,int target) {
        int lo = 0;
        int hi = arr.length-1;
        
        int pans = -1;
        while(lo <= hi) {
            int mid = lo+ (hi-lo)/2;
            if(arr[mid] == target) {
                pans = mid;
                hi = mid - 1;
            } else if(arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return pans;
    }
    
    private int lastIndex(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length-1;
        
        int pans = -1;
        while(lo <= hi) {
            int mid = lo+ (hi-lo)/2;
            if(arr[mid] == target) {
                pans = mid;
                lo = mid + 1;
            } else if(arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return pans;
    }
}   

