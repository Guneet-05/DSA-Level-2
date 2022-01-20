package Searching_And_Sorting.Binary_Search.Codes;

public class Firstbadversion {
    
    public static void main(String[] args) {
        
    }

    
    // this function is just a dummy. It is provided by leetcode in the question and the code is hidden
    public boolean isBadVersion(int n) {
        return true; 
    }

    public int firstBadVersion(int n) {
        
        int lo = 1;
        int hi = n;
        
        int pa = -1;
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            
            if(isBadVersion(mid)) {
                pa = mid;
                hi = mid -1;
            } else {
                lo = mid + 1;
            }
        }
        
        return pa;
    }
}
