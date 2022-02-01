public class Solution {
    static long m =  10000003;
    public int paint(int A, int B, int[] C) {
       long max = Long.MIN_VALUE;
       long sum = 0;

        for(int i=0;i<C.length;i++) {
            if(C[i] > max) max = C[i];

            sum += C[i];
        }

        long lo = max;
        long hi = sum;
        long pa = 0;

        if(A == C.length) return (int)((B*lo)%m);
        if(A == 1) return (int)((B*hi)%m);

        while(lo <= hi) {
            long mid = lo + (hi-lo)/2;

            if(isPossible(C,(int)mid,A) == true) {
                pa = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return (int)((B*pa)%m);
    }
    public boolean isPossible(int[] nums, int maxSum, int m) {
        
        int subArrays = 1;
        int sum = 0;
        
        for(int i=0;i<nums.length;i++) {
            if(sum + nums[i] <= maxSum) {
                sum += nums[i];
            } else {
                sum = nums[i];
                subArrays++;
            }
        }
        
        if(subArrays <= m) return true;
        return false;
    }
}
