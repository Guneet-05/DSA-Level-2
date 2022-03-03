class Solution {
    public int minSubArrayLen(int k, int[] nums) {
        int left = 0, minLen = Integer.MAX_VALUE, sum = 0;
        
        for(int right=0;right<nums.length;right++) {
            sum += nums[right];
            
            while(sum >= k) {
                minLen = Math.min(minLen,right -left + 1);
                sum = sum- nums[left];
                left++;
            }
            
        }
        
        if(minLen == Integer.MAX_VALUE) return 0;
        return minLen;
    }
}
