class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        
        int lo = 0;
        int hi = nums.length-1;
        
        while(lo < hi) {
            if(nums[lo] + nums[hi] == k) {
                ans ++;
                lo++;
                hi--;
            } else if(nums[lo] + nums[hi] < k) {
                lo++;
            } else {
                hi--;
            }
        }
        
        return ans;
    }
}
