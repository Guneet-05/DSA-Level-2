class Solution {
    
    public int numberOfSubarraysWithAtmost(int[] nums, int k) {
        int left = 0, ans = 0, odd = 0;
        
        for(int right = 0; right<nums.length;right++) {
            if(nums[right] % 2 == 1) odd++;
            
            while(odd > k) {
               if(nums[left] % 2 == 1) {
                   odd--;
               }    
                
               left++;
            }
            
            ans += (right - left + 1);
        }
        
        return ans;
    }
    
    public int numberOfSubarrays(int[] nums, int k) {
       return numberOfSubarraysWithAtmost(nums,k) - numberOfSubarraysWithAtmost(nums,k-1);
    }
}
