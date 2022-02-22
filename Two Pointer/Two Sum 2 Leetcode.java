class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int lo = 0;
        int hi = nums.length-1;
        
        while(lo < hi) {
            if(nums[lo] + nums[hi] < target) {
                lo++;
            } else if(nums[lo] + nums[hi] > target) {
                hi--;
            } else {
                return new int[]{lo+1,hi+1};
            }
        }
        
        return null;
    }
}
