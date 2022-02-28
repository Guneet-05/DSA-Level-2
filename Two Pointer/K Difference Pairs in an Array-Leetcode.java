class Solution {
    
    public int diffPair(int[] nums,int target) {
        int left = 0, right = 1;
        int count = 0;
        while(left< nums.length && right < nums.length) {
            
            if(left > 0 && nums[left] == nums[left-1]) {
                left++; continue;
            }
            
            if(left == right) {
                right++; continue;
            }
            
            int diff = nums[right] - nums[left];
            if(diff == target) {
                left++;
                count++;
            } else if(diff < target) {
                right++;
            } else {
                left++;
            }
        }
        
        return count;
    }
    
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        return diffPair(nums,k);
    }
}
