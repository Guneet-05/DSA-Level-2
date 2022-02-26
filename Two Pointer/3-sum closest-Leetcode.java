class Solution {
    
    public int twoSumClosest(int[] nums,int target, int lo, int hi) {
        int minDiff = Integer.MAX_VALUE;
        int ans = 0;
        
        while(lo < hi) {
            int sum = nums[lo] + nums[hi];
            if(sum == target) {
                return target;
            } else if(sum > target) {
                int currDiff = sum - target;
                if(currDiff < minDiff) {
                    minDiff = currDiff;
                    ans = sum;
                }
                hi--;
            } else {
                int currDiff = target - sum;
                if(currDiff < minDiff) {
                    minDiff = currDiff;
                    ans = sum;
                }
                lo++;
            }
        }
        return ans;
    }
    
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int ans = 0;
        
        for(int i=0;i<nums.length-2;i++) {
            int closestPairSum = twoSumClosest(nums,target-nums[i],i+1,nums.length-1);
            int currSum = closestPairSum + nums[i];
            int currDiff = Math.abs(target - currSum);
            if(currDiff < minDiff) {
                minDiff = currDiff;
                ans = currSum;
            }
        }
        
        return ans;
    }
}
