class Solution {
    public int mySqrt(int x) {
       
        if(x == 0) return 0;
        long lo = 1;
        long hi = x;
        
        long pa = 0;
        
        while(lo <= hi) {
            long mid = lo + (hi-lo)/2;
            
            if(mid * mid == x) return (int)mid;
            else if(mid * mid < x) {
                pa = mid;
                lo = mid + 1;
            } else {
                hi = mid -1;
            }
        }
        
        return(int) pa;
    }
}
