public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        // write your code here
        Arrays.sort(nums);

        int lo = 0;
        int hi = nums.length-1;
        int ans = 0;
        while(lo < hi) {
            int sum = nums[lo] + nums[hi];
            if(sum <= target) {
                ans += (hi-lo);
                lo++;
            } else {
                hi--;
            }
        }

        return ans;
    }
}
