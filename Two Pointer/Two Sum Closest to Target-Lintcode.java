public class Solution {
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int lo = 0;
        int hi = nums.length-1;

        while(lo < hi) {
            int sum = nums[lo] + nums[hi];
            if(sum == target) {
                minDiff = 0;
                return minDiff;
            } else if(sum < target) {
                int currDiff = Math.abs(target-sum);
                if(currDiff < minDiff) minDiff = currDiff;
                lo++;
            } else {
                int currDiff = Math.abs(target-sum);
                if(currDiff < minDiff) minDiff = currDiff;
                hi--;
            }
        } 

        return minDiff;
    }
}
