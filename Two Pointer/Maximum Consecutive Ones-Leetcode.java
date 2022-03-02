class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        
        int i = 0;
        while(i < nums.length) {
            count = 0;
            while(i<nums.length && nums[i] == 1) {
                count++;i++;
            }
            maxCount = Math.max(count,maxCount);
            i++;
        }
        
        return maxCount;
    }
}S
