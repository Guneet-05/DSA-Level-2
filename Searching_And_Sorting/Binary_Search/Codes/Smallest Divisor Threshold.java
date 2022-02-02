class Solution {
    
    public boolean isPossible(int mid,int []nums, int threshold) {
        
        int curr = 0;
        
        for(int i=0;i<nums.length;i++) {
            curr = curr + nums[i]/mid;
            if(nums[i] % mid != 0) curr++;
        }
        
        if(curr <= threshold) return true;
        return false;
    }
    
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1;
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            max = Math.max(nums[i],max);
        }
        
        int hi = max;
        int pa = nums.length;
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            
            if(isPossible(mid,nums,threshold)) {
                pa = mid;
                hi = mid -1;
            } else {
                lo = mid +1;
            }
        }
        
        return pa;
    }
}
