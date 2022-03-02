class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0, countOfZeroes = 0,left = 0;
        
        for(int right=0;right<nums.length;right++) {
            if(nums[right] == 0) {
                countOfZeroes++;
            }
            
            //make subarray valid by excluding left elements
            while(countOfZeroes > k) {
                if(nums[left] == 0) countOfZeroes--;
                left++;
            }
            
            maxLen = Math.max(maxLen,right - left + 1);
        }
        
        return maxLen;
    }
}
