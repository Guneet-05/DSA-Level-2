class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left =  0;
        int count = 0;
        int product = 1;
        
        for(int right=0;right<nums.length;right++) {
            product = product * nums[right];
            
            while(left < nums.length && product >= k) {
                product = product/nums[left];
                left++;
            }
            
            count += (right - left + 1);
        }
        
        if(count < 0) return 0;
        return count;
    }
}
