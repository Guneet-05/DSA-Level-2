public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // write your code here
        int lo = 0;
        int hi = nums.length-1;
        int ans = 0;
        Arrays.sort(nums);
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
}
