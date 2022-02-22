public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums.length-1;

        int ans = 0;
        while(lo < hi) {
            if(lo > 0 && nums[lo-1] == nums[lo]) {
                lo++;
                continue;
            }

            if(nums[lo] + nums[hi]  == target) {
                ans++;
                lo++;
                hi--;
            } else if(nums[lo] + nums[hi] < target) {
                lo++;
            } else {
                hi--;
            }
        } 

        return ans;
    }
}
