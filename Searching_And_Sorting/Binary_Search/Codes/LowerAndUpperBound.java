import java.util.Scanner;
public class Main {
     
    public static int lowerBound(int[] arr, int target) {
        
        //we have to return the first occ if found else ceil
        
        int lo = 0;
        int hi = arr.length -1;
        int pa = arr.length;
        
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(arr[mid] >= target) {
                pa = mid;
                hi = mid -1;
            } else {
                lo = mid + 1;
            }
        }
        
        return pa;
    } 
     
    public static int upperBound(int[] arr, int target) {
        
        // we have to find the ceil only
        
        int lo = 0;
        int hi = arr.length-1;
        
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(arr[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid -1;
            }
        }
        
        return lo;
    }
}
