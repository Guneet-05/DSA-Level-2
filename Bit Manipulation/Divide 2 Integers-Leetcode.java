class Solution {
    public int divide(int dividend, int divisor) {
     
        if(dividend == 1 << 31 && divisor == -1) return Integer.MAX_VALUE;
        
        if(divisor == 1) return dividend;
        
        boolean sign = (dividend >= 0) == (divisor >= 0) ? true : false;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        
        int res = 0;
        while(dividend - divisor >= 0) {
            res++;
            dividend -= divisor;
        }
        
        return sign ? res: -res;
    }
}
