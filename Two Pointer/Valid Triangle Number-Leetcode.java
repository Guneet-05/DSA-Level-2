class Solution {
    
     public int twoSumGreater(int[] nums, int target,int lo, int hi) {
        // write your code here
        int ans = 0;
        while(lo < hi) {
            int sum = nums[lo] + nums[hi];
            if(sum > target) {
                ans += (hi-lo);
                hi--;
            } else {
                lo++;
            }
        }

        return ans;
    }
    
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        
        for(int i=nums.length-1;i>1;i--) {
            ans += twoSumGreater(nums,nums[i],0,i-1);
        }
        
        return ans;
    }
}
