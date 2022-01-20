package Searching_And_Sorting.Binary_Search.Codes;

public class TransitionPoint {
    public static void main(String[] args) {
        
    }

    public int transitionPoint(int arr[], int n) {
        // code here
        int lo = 0;
        int hi = n-1;
        
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
}
