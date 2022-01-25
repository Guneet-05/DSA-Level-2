  public int floorSqrt(int x) {
       
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

public double sqrtWithPrecision(int n, int precision) {
    double ans = floorSqrt(n);
    double i= 0.1; //initial precision
    
    while(precision-- > 0) {
        while(ans * ans <= n) ans += i;
        ans = ans-i;
        i = i/10;
    }
    
    return ans;
}
