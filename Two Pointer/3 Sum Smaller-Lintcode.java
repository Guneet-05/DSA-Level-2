public class Solution {
    /**
     * @param nums:  an array of n integers
     * @param target: a target
     * @return: the number of index triplets satisfy the condition nums[i] + nums[j] + nums[k] < target
     */

    public int twoSumSmaller(int[] nums, int target,int lo, int hi) {
        int ans = 0;
        while(lo < hi) {
            int sum = nums[lo]+nums[hi];
            if(sum < target) {
                ans += (hi-lo);
                System.out.println(nums[lo] + " " + nums[hi]);
                lo++;
            } else {
                hi--;
            }
        }
        return ans;
    }

    public int threeSumSmaller(int[] nums, int target) {
        // Write your code 
        Arrays.sort(nums);

        int ans = 0;
        for(int i=0;i<nums.length;i++) {
            // if(i> 0 && nums[i-1] == nums[i]) continue;
            int numberOfPairs = twoSumSmaller(nums,target - nums[i],i+1,nums.length-1);
            ans += numberOfPairs;
        }

        return ans;
    }
}
